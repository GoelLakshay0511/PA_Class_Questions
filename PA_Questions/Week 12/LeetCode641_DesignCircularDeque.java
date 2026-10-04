public class LeetCode641_DesignCircularDeque {
    static class MyCircularDeque {
        private int[] buffer;
        private int front;
        private int rear;
        private int size;
        private int capacity;

        public MyCircularDeque(int k) {
            this.capacity = k;
            this.buffer = new int[k];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
        }

        public boolean insertFront(int value) {
            if (isFull()) return false;
            front = (front - 1 + capacity) % capacity;
            buffer[front] = value;
            size++;
            return true;
        }

        public boolean insertLast(int value) {
            if (isFull()) return false;
            buffer[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
            return true;
        }

        public boolean deleteFront() {
            if (isEmpty()) return false;
            front = (front + 1) % capacity;
            size--;
            return true;
        }

        public boolean deleteLast() {
            if (isEmpty()) return false;
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }

        public int getFront() {
            return isEmpty() ? -1 : buffer[front];
        }

        public int getRear() {
            return isEmpty() ? -1 : buffer[(rear - 1 + capacity) % capacity];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == capacity;
        }
    }

    public static void main(String[] args) {
        MyCircularDeque deque = new MyCircularDeque(3);
        System.out.println(deque.insertLast(1));
        System.out.println(deque.insertLast(2));
        System.out.println(deque.insertFront(3));
        System.out.println("Front: " + deque.getFront()); // 3
        System.out.println("Rear: " + deque.getRear());   // 2
    }
}
