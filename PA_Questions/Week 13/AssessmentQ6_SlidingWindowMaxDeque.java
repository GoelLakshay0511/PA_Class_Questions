import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class AssessmentQ6_SlidingWindowMaxDeque {
    public static int[] getSlidingWindowMax(int[] arr, int k) {
        int n = arr.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }
            while (!dq.isEmpty() && arr[dq.peekLast()] <= arr[i]) {
                dq.pollLast();
            }
            dq.addLast(i);
            if (i >= k - 1) {
                res[i - k + 1] = arr[dq.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        System.out.println("Sliding Max (k=3): " + Arrays.toString(getSlidingWindowMax(arr, 3)));
    }
}
