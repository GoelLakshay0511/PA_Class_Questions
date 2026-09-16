public class CLL_SplitHalves {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    static class NodePair {
        Node head1, head2;
        NodePair(Node h1, Node h2) { this.head1 = h1; this.head2 = h2; }
    }

    public static NodePair splitList(Node head) {
        if (head == null) return new NodePair(null, null);

        Node slow = head, fast = head;
        while (fast.next != head && fast.next.next != head) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if (fast.next.next == head) {
            fast = fast.next;
        }

        Node head1 = head;
        Node head2 = slow.next;
        fast.next = slow.next;
        slow.next = head;

        return new NodePair(head1, head2);
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n1;

        NodePair halves = splitList(n1);
        System.out.println("First half head: " + halves.head1.data);
        System.out.println("Second half head: " + halves.head2.data);
    }
}
