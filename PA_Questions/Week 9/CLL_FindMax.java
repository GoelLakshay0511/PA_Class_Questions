public class CLL_FindMax {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static int findMax(Node head) {
        if (head == null) return Integer.MIN_VALUE;
        int max = head.data;
        Node curr = head.next;
        while (curr != head) {
            if (curr.data > max) max = curr.data;
            curr = curr.next;
        }
        return max;
    }

    public static void main(String[] args) {
        Node n1 = new Node(15);
        Node n2 = new Node(42);
        Node n3 = new Node(8);
        n1.next = n2; n2.next = n3; n3.next = n1;
        System.out.println("Max element: " + findMax(n1)); // 42
    }
}
