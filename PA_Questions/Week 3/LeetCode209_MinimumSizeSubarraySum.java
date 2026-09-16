public class LeetCode209_MinimumSizeSubarraySum {
    public static int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println("Min SubArray Len: " + minSubArrayLen(7, nums)); // 2 ([4, 3])
    }
}
