import java.util.Arrays;

public class AssessmentQ2_CircularBufferRotation {
    public static void rotateBuffer(int[] buffer, int k) {
        int n = buffer.length;
        k %= n;
        reverse(buffer, 0, n - 1);
        reverse(buffer, 0, k - 1);
        reverse(buffer, k, n - 1);
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] buffer = {1, 2, 3, 4, 5, 6, 7};
        rotateBuffer(buffer, 3);
        System.out.println("Rotated Buffer: " + Arrays.toString(buffer));
    }
}
