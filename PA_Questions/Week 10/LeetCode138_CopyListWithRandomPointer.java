import java.util.HashMap;
import java.util.Map;

public class LeetCode138_CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next, random;
        Node(int val) { this.val = val; }
    }

    public static Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        n1.next = n2;
        n2.random = n1;

        Node copy = copyRandomList(n1);
        System.out.println("Copied head val: " + copy.val + ", next random val: " + copy.next.random.val);
    }
}
