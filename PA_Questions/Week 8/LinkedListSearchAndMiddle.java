public class LinkedListSearchAndMiddle {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static boolean search(ListNode head, int target) {
        ListNode curr = head;
        while (curr != null) {
            if (curr.val == target) return true;
            curr = curr.next;
        }
        return false;
    }

    public static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        System.out.println("Found 3: " + search(head, 3));
        System.out.println("Middle node: " + findMiddle(head).val); // 3
    }
}
