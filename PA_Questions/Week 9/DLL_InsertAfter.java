public class DLL_InsertAfter {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    public static void insertAfter(Node prevNode, int newData) {
        if (prevNode == null) return;
        Node newNode = new Node(newData);
        newNode.next = prevNode.next;
        prevNode.next = newNode;
        newNode.prev = prevNode;
        if (newNode.next != null) {
            newNode.next.prev = newNode;
        }
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        insertAfter(head, 20);
        System.out.println("Head: " + head.data + ", Next: " + head.next.data);
    }
}
