import java.util.*;

class Solution {

    List<List<String>> result = new ArrayList<>();

    // Check if placing a queen at (row, col) is safe
    public static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // vertical up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q')
                return false;
        }

        // left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q')
                return false;
        }

        // right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q')
                return false;
        }

        return true;
    }

    // Converts board to List<String>
    public List<String> returnBoard(char[][] board) {
        List<String> temp = new ArrayList<>();
        
        for (int i = 0; i < board.length; i++) {
            temp.add(new String(board[i]));
        }
        return temp;
    }

    // Backtracking function
    public void nqueens(char[][] board, int row) {
        int n = board.length;

        // Base case: all queens placed
        if (row == n) {
            result.add(returnBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isSafe(board, row, col)) {
                board[row][col] = 'Q';      // place queen
                nqueens(board, row + 1);    // recursive call
                board[row][col] = '.';      // backtrack
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];

        // Fill board with dots
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        nqueens(board, 0);

        return result;
    }
}
