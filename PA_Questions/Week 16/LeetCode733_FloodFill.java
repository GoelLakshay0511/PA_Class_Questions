public class LeetCode733_FloodFill {
    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if (originalColor != color) {
            dfs(image, sr, sc, originalColor, color);
        }
        return image;
    }

    private static void dfs(int[][] image, int r, int c, int originalColor, int color) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != originalColor) {
            return;
        }

        image[r][c] = color;
        dfs(image, r + 1, c, originalColor, color);
        dfs(image, r - 1, c, originalColor, color);
        dfs(image, r, c + 1, originalColor, color);
        dfs(image, r, c - 1, originalColor, color);
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
        floodFill(image, 1, 1, 2);
        System.out.println("Pixel (1,1): " + image[1][1]); // 2
    }
}
