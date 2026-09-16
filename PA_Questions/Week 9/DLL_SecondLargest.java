public class DLL_SecondLargest {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    public static int findSecondLargest(Node head) {
        if (head == null || head.next == null) return -1;
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        Node curr = head;
        while (curr != null) {
            if (curr.data > max) {
                secondMax = max;
                max = curr.data;
            } else if (curr.data > secondMax && curr.data != max) {
                secondMax = curr.data;
            }
            curr = curr.next;
        }
        return secondMax == Integer.MIN_VALUE ? -1 : secondMax;
    }

    public static void main(String[] args) {
        Node n1 = new Node(10);
        Node n2 = new Node(50);
        Node n3 = new Node(30);
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        System.out.println("Second Largest: " + findSecondLargest(n1)); // 30
    }
}
