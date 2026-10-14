import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class AssessmentQ1_ServiceDeskQueue {
    static class ServiceDesk {
        private Queue<Integer> queue = new LinkedList<>();
        private Set<Integer> cancelled = new HashSet<>();

        public void addRequest(int ticketId) {
            queue.add(ticketId);
        }

        public void cancelRequest(int ticketId) {
            cancelled.add(ticketId);
        }

        public Integer serveNext() {
            while (!queue.isEmpty()) {
                int ticket = queue.poll();
                if (!cancelled.contains(ticket)) {
                    return ticket;
                }
            }
            return null; // All requests served or cancelled
        }
    }

    public static void main(String[] args) {
        ServiceDesk desk = new ServiceDesk();
        desk.addRequest(101);
        desk.addRequest(102);
        desk.addRequest(103);
        desk.cancelRequest(102);

        System.out.println("Served: " + desk.serveNext()); // 101
        System.out.println("Served: " + desk.serveNext()); // 103 (102 skipped)
    }
}
