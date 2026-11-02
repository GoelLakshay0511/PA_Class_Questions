import java.util.Arrays;
import java.util.PriorityQueue;

public class LeetCode973_KClosestPointsToOrigin {
    public static int[][] kClosest(int[][] points, int k) {
        // Max-heap based on distance to origin
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare((b[0]*b[0] + b[1]*b[1]), (a[0]*a[0] + a[1]*a[1]))
        );

        for (int[] point : points) {
            maxHeap.add(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] points = {{1, 3}, {-2, 2}};
        int[][] result = kClosest(points, 1);
        System.out.println("Closest: " + Arrays.deepToString(result)); // [[-2, 2]]
    }
}
