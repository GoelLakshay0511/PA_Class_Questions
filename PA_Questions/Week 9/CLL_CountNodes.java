public class CLL_CountNodes {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static int countNodes(Node head) {
        if (head == null) return 0;
        int count = 0;
        Node curr = head;
        do {
            count++;
            curr = curr.next;
        } while (curr != head);
        return count;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        n1.next = n2; n2.next = n1;
        System.out.println("Nodes count: " + countNodes(n1)); // 2
    }
}
