import java.util.*;

public class LeetCode347_TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Min-heap ordered by frequency
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            Comparator.comparingInt(countMap::get)
        );

        for (int n : countMap.keySet()) {
            heap.add(n);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        int[] top = new int[k];
        for (int i = k - 1; i >= 0; --i) {
            top[i] = heap.poll();
        }
        return top;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        System.out.println("Top 2 Frequent: " + Arrays.toString(topKFrequent(nums, 2))); // [1, 2]
    }
}
