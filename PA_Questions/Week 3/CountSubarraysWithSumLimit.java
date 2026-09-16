public class CountSubarraysWithSumLimit {
    public static int countSubarrays(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > k && left <= right) {
                sum -= nums[left++];
            }
            count += (right - left + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Subarrays with sum <= 3: " + countSubarrays(nums, 3));
    }
}
