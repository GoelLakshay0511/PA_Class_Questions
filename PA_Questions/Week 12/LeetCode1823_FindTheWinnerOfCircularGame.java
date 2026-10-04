public class LeetCode1823_FindTheWinnerOfCircularGame {
    public static int findTheWinner(int n, int k) {
        int winner = 0; // Base case for 1 person (0-indexed)
        for (int i = 1; i <= n; i++) {
            winner = (winner + k) % i;
        }
        return winner + 1; // Convert to 1-indexed
    }

    public static void main(String[] args) {
        System.out.println("Winner (n=5, k=2): " + findTheWinner(5, 2)); // 3
    }
}
