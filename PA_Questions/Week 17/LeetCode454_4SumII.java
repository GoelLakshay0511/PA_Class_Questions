import java.util.HashMap;
import java.util.Map;

public class LeetCode454_4SumII {
    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                sumMap.put(a + b, sumMap.getOrDefault(a + b, 0) + 1);
            }
        }

        int count = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                count += sumMap.getOrDefault(-(c + d), 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};
        System.out.println("4Sum II Count: " + fourSumCount(nums1, nums2, nums3, nums4)); // 2
    }
}
