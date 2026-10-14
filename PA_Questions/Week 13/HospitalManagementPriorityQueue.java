import java.util.PriorityQueue;

public class HospitalManagementPriorityQueue {
    static class Patient implements Comparable<Patient> {
        String name;
        int severity; // 1 = Critical, 2 = Urgent, 3 = Normal

        Patient(String name, int severity) {
            this.name = name;
            this.severity = severity;
        }

        @Override
        public int compareTo(Patient other) {
            return Integer.compare(this.severity, other.severity);
        }

        @Override
        public String toString() {
            return name + " (Severity: " + severity + ")";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Patient> erQueue = new PriorityQueue<>();

        erQueue.add(new Patient("Alice", 3));
        erQueue.add(new Patient("Bob", 1));
        erQueue.add(new Patient("Charlie", 2));
        erQueue.add(new Patient("Diana", 1));

        System.out.println("Emergency Room Treatment Order:");
        while (!erQueue.isEmpty()) {
            System.out.println("Treating: " + erQueue.poll());
        }
    }
}
