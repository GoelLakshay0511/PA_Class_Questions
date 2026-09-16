public class DLL_ReverseList {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    public static Node reverseDLL(Node head) {
        Node temp = null;
        Node current = head;

        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        if (temp != null) {
            head = temp.prev;
        }
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2; n2.prev = n1;
        Node rev = reverseDLL(n1);
        System.out.println("Reversed DLL Head: " + rev.data);
    }
}
