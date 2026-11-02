public class CustomMaxHeapImplementation {
    private int[] heap;
    private int size;
    private int capacity;

    public CustomMaxHeapImplementation(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int i) { return (i - 1) / 2; }
    private int leftChild(int i) { return 2 * i + 1; }
    private int rightChild(int i) { return 2 * i + 2; }

    public void insert(int val) {
        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }
        heap[size] = val;
        int current = size;
        size++;

        while (current != 0 && heap[current] > heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int extractMax() {
        if (size <= 0) return Integer.MIN_VALUE;
        if (size == 1) {
            size--;
            return heap[0];
        }

        int root = heap[0];
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);

        return root;
    }

    private void maxHeapify(int i) {
        int left = leftChild(i);
        int right = rightChild(i);
        int largest = i;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public static void main(String[] args) {
        CustomMaxHeapImplementation maxHeap = new CustomMaxHeapImplementation(10);
        maxHeap.insert(3);
        maxHeap.insert(10);
        maxHeap.insert(12);
        maxHeap.insert(8);
        maxHeap.insert(2);
        maxHeap.insert(14);

        System.out.println("Extract Max: " + maxHeap.extractMax()); // 14
        System.out.println("Extract Max: " + maxHeap.extractMax()); // 12
    }
}
