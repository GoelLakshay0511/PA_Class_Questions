import java.util.LinkedList;
import java.util.Queue;

public class LeetCode933_NumberOfRecentCalls {
    static class RecentCounter {
        private Queue<Integer> requests;

        public RecentCounter() {
            requests = new LinkedList<>();
        }

        public int ping(int t) {
            requests.add(t);
            while (!requests.isEmpty() && requests.peek() < t - 3000) {
                requests.poll();
            }
            return requests.size();
        }
    }

    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));    // 1
        System.out.println(counter.ping(100));  // 2
        System.out.println(counter.ping(3001)); // 3
        System.out.println(counter.ping(3002)); // 3
    }
}
