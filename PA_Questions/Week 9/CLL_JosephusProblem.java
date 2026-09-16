public class CLL_JosephusProblem {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static int getJosephusPosition(int n, int k) {
        Node head = new Node(1);
        Node prev = head;
        for (int i = 2; i <= n; i++) {
            prev.next = new Node(i);
            prev = prev.next;
        }
        prev.next = head;

        Node ptr1 = head, ptr2 = head;
        while (ptr1.next != ptr1) {
            for (int count = 0; count < k - 1; count++) {
                ptr2 = ptr1;
                ptr1 = ptr1.next;
            }
            ptr2.next = ptr1.next;
            ptr1 = ptr2.next;
        }
        return ptr1.data;
    }

    public static void main(String[] args) {
        System.out.println("Survivor (n=5, k=2): " + getJosephusPosition(5, 2)); // 3
    }
}
