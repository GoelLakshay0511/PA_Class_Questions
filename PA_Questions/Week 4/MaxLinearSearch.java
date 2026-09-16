public class MaxLinearSearch {
    public static int findMax(int[] arr) {
        if (arr == null || arr.length == 0) throw new IllegalArgumentException("Array is empty");
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {12, 45, 2, 89, 34};
        System.out.println("Max element: " + findMax(nums)); // 89
    }
}
