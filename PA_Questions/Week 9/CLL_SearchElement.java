public class CLL_SearchElement {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static boolean search(Node head, int target) {
        if (head == null) return false;
        Node curr = head;
        do {
            if (curr.data == target) return true;
            curr = curr.next;
        } while (curr != head);
        return false;
    }

    public static void main(String[] args) {
        Node n1 = new Node(10);
        n1.next = n1;
        System.out.println("Search 10: " + search(n1, 10)); // true
    }
}
