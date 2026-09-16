public class DLL_CheckPalindrome {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    public static boolean isPalindrome(Node head) {
        if (head == null) return true;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        while (head != tail && head.prev != tail) {
            if (head.data != tail.data) return false;
            head = head.next;
            tail = tail.prev;
        }
        return true;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(1);
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        System.out.println("Is Palindrome: " + isPalindrome(n1)); // true
    }
}
