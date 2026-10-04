public class LeetCode622_DesignCircularQueue {
    static class MyCircularQueue {
        private int[] data;
        private int head;
        private int tail;
        private int size;
        private int k;

        public MyCircularQueue(int k) {
            this.data = new int[k];
            this.head = 0;
            this.tail = -1;
            this.size = 0;
            this.k = k;
        }

        public boolean enQueue(int value) {
            if (isFull()) return false;
            tail = (tail + 1) % k;
            data[tail] = value;
            size++;
            return true;
        }

        public boolean deQueue() {
            if (isEmpty()) return false;
            head = (head + 1) % k;
            size--;
            return true;
        }

        public int Front() {
            return isEmpty() ? -1 : data[head];
        }

        public int Rear() {
            return isEmpty() ? -1 : data[tail];
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public boolean isFull() {
            return size == k;
        }
    }

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.enQueue(1)); // return True
        System.out.println(myCircularQueue.enQueue(2)); // return True
        System.out.println(myCircularQueue.enQueue(3)); // return True
        System.out.println(myCircularQueue.enQueue(4)); // return False
        System.out.println(myCircularQueue.Rear());     // return 3
        System.out.println(myCircularQueue.isFull());   // return True
        System.out.println(myCircularQueue.deQueue());  // return True
        System.out.println(myCircularQueue.enQueue(4)); // return True
        System.out.println(myCircularQueue.Rear());     // return 4
    }
}
