public class CountOccurrencesBinarySearch {
    public static int countOccurrences(int[] arr, int target) {
        int first = findBound(arr, target, true);
        if (first == -1) return 0;
        int last = findBound(arr, target, false);
        return last - first + 1;
    }

    private static int findBound(int[] arr, int target, boolean isFirst) {
        int low = 0, high = arr.length - 1;
        int result = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target) {
                result = mid;
                if (isFirst) high = mid - 1;
                else low = mid + 1;
            } else if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        System.out.println("Occurrences of 2: " + countOccurrences(arr, 2)); // 3
    }
}
