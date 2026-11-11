public class LeetCode130_SurroundedRegions {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int rows = board.length;
        int cols = board[0].length;

        // Phase 1: Mark non-surrounded 'O's on boundary as 'E'
        for (int r = 0; r < rows; r++) {
            if (board[r][0] == 'O') dfs(board, r, 0);
            if (board[r][cols - 1] == 'O') dfs(board, r, cols - 1);
        }
        for (int c = 0; c < cols; c++) {
            if (board[0][c] == 'O') dfs(board, 0, c);
            if (board[rows - 1][c] == 'O') dfs(board, rows - 1, c);
        }

        // Phase 2: Flip 'O' -> 'X', 'E' -> 'O'
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 'O') board[r][c] = 'X';
                else if (board[r][c] == 'E') board[r][c] = 'O';
            }
        }
    }

    private static void dfs(char[][] board, int r, int c) {
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != 'O') {
            return;
        }
        board[r][c] = 'E';
        dfs(board, r + 1, c);
        dfs(board, r - 1, c);
        dfs(board, r, c + 1);
        dfs(board, r, c - 1);
    }

    public static void main(String[] args) {
        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };
        solve(board);
        System.out.println("Board solved. Center cell: " + board[1][1]); // 'X'
    }
}
