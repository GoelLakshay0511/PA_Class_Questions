public class LeetCode86_PartitionList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode beforeDummy = new ListNode(0);
        ListNode afterDummy = new ListNode(0);
        ListNode before = beforeDummy;
        ListNode after = afterDummy;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterDummy.next;
        return beforeDummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        ListNode res = partition(head, 3);
        System.out.print("Partitioned: ");
        while (res != null) {
            System.out.print(res.val + " ");
            res = res.next;
        }
        System.out.println();
    }
}
