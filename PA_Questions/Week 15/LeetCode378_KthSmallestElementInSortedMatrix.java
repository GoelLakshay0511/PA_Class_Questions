import java.util.PriorityQueue;

public class LeetCode378_KthSmallestElementInSortedMatrix {
    static class Cell {
        int val, row, col;
        Cell(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }
    }

    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (int i = 0; i < Math.min(n, k); i++) {
            minHeap.offer(new Cell(matrix[i][0], i, 0));
        }

        for (int i = 0; i < k - 1; i++) {
            Cell cell = minHeap.poll();
            if (cell.col + 1 < n) {
                minHeap.offer(new Cell(matrix[cell.row][cell.col + 1], cell.row, cell.col + 1));
            }
        }

        return minHeap.poll().val;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        System.out.println("8th smallest: " + kthSmallest(matrix, 8)); // 13
    }
}
