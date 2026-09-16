public class CLL_DeleteNode {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static Node deleteNode(Node head, int key) {
        if (head == null) return null;
        Node curr = head, prev = null;

        while (curr.data != key) {
            if (curr.next == head) return head; // Not found
            prev = curr;
            curr = curr.next;
        }

        if (curr == head && curr.next == head) {
            return null; // Only one node
        }

        if (curr == head) {
            prev = head;
            while (prev.next != head) prev = prev.next;
            head = head.next;
            prev.next = head;
        } else {
            prev.next = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2; n2.next = n1;
        Node head = deleteNode(n1, 1);
        System.out.println("New Head: " + head.data);
    }
}
