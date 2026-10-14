import java.util.PriorityQueue;

public class AssessmentQ3_PriorityLabAccess {
    static class StudentRequest implements Comparable<StudentRequest> {
        String name;
        int rolePriority; // 1 = PhD/Faculty, 2 = Masters, 3 = Undergrad

        StudentRequest(String name, int rolePriority) {
            this.name = name;
            this.rolePriority = rolePriority;
        }

        @Override
        public int compareTo(StudentRequest other) {
            return Integer.compare(this.rolePriority, other.rolePriority);
        }
    }

    public static void main(String[] args) {
        PriorityQueue<StudentRequest> labQueue = new PriorityQueue<>();
        labQueue.add(new StudentRequest("John (UG)", 3));
        labQueue.add(new StudentRequest("Dr. Smith (Faculty)", 1));
        labQueue.add(new StudentRequest("Emma (MS)", 2));

        System.out.println("Lab Access Granted Order:");
        while (!labQueue.isEmpty()) {
            StudentRequest req = labQueue.poll();
            System.out.println("- " + req.name);
        }
    }
}
