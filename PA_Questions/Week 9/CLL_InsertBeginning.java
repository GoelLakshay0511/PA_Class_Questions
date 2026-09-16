public class CLL_InsertBeginning {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static Node insertBeginning(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = head;
        return newNode;
    }

    public static void main(String[] args) {
        Node head = insertBeginning(null, 5);
        head = insertBeginning(head, 2);
        System.out.println("Head: " + head.data + ", Next: " + head.next.data);
    }
}
