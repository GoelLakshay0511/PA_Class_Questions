public class CircularQueueImplementation {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueueImplementation(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }

    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full!");
            return false;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = value;
        size++;
        return true;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return -1;
        }
        int val = queue[front];
        front = (front + 1) % capacity;
        size--;
        return val;
    }

    public int front() {
        return isEmpty() ? -1 : queue[front];
    }

    public int rear() {
        return isEmpty() ? -1 : queue[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        CircularQueueImplementation q = new CircularQueueImplementation(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println("Front: " + q.front());
        System.out.println("Dequeued: " + q.dequeue());
        q.enqueue(4);
        System.out.println("Rear: " + q.rear());
    }
}
