public class DLL_DeleteAllOccurrences {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    public static Node deleteAllOccurrences(Node head, int target) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == target) {
                if (curr.prev != null) curr.prev.next = curr.next;
                else head = curr.next;

                if (curr.next != null) curr.next.prev = curr.prev;
            }
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(2);
        head.next = new Node(2);
        head.next.prev = head;
        head = deleteAllOccurrences(head, 2);
        System.out.println("Head after deleting all 2s: " + (head == null ? "null" : head.data));
    }
}
