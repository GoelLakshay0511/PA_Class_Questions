import java.util.LinkedList;
import java.util.Queue;

public class LeetCode346_MovingAverageFromDataStream {
    static class MovingAverage {
        private Queue<Integer> queue;
        private int size;
        private double sum;

        public MovingAverage(int size) {
            this.size = size;
            this.queue = new LinkedList<>();
            this.sum = 0.0;
        }

        public double next(int val) {
            if (queue.size() == size) {
                sum -= queue.poll();
            }
            queue.offer(val);
            sum += val;
            return sum / queue.size();
        }
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1)); // 1.0
        System.out.println(m.next(10)); // 5.5
        System.out.println(m.next(3)); // 4.66667
        System.out.println(m.next(5)); // 6.0
    }
}
