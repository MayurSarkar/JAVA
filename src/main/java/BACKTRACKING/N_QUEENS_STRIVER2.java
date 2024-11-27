package BACKTRACKING;
import java.util.*;

public class N_QUEENS_STRIVER2 {
    // Main function to solve N-Queens
    public static List<List<String>> solveNQueens(int n) {
        // Create a board of size n x n filled with '.' (empty spaces)
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';  // Initialize the board with dots
            }
        }

        // List to store all valid solutions
        List<List<String>> res = new ArrayList<>();

        // Auxiliary arrays to keep track of attacks on rows and diagonals:
        // leftRow[i] will be 1 if there's a queen in row i, otherwise 0
        int[] leftRow = new int[n];

        // lowerDiagonal[i] will be 1 if there's a queen in lower diagonal, otherwise 0
        int[] lowerDiagonal = new int[2 * n - 1];

        // upperDiagonal[i] will be 1 if there's a queen in upper diagonal, otherwise 0
        int[] upperDiagonal = new int[2 * n - 1];

        // Start the recursive solving process from the first column
        solve(0, board, res, leftRow, lowerDiagonal, upperDiagonal);

        // Return all valid solutions
        return res;
    }

    // Recursive function to try placing queens column by column
    static void solve(int col, char[][] board, List<List<String>> res, int[] leftRow, int[] lowerDiagonal, int[] upperDiagonal) {
        // Base case: if we've placed queens in all columns, add the solution to the result
        if (col == board.length) {
            res.add(construct(board));  // Add the current valid board configuration to the result list
            return;
        }

        // Try placing a queen in each row of the current column
        for (int row = 0; row < board.length; row++) {
            // Check if placing a queen at (row, col) is valid:
            // - leftRow[row] == 0: No queen in the same row
            // - lowerDiagonal[row + col] == 0: No queen in the lower diagonal
            // - upperDiagonal[board.length - 1 + col - row] == 0: No queen in the upper diagonal
            if (leftRow[row] == 0 && lowerDiagonal[row + col] == 0 && upperDiagonal[board.length - 1 + col - row] == 0) {

                // Place the queen at (row, col)
                board[row][col] = 'Q';

                // Mark this row and diagonals as attacked
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[board.length - 1 + col - row] = 1;

                // Recursively solve for the next column
                solve(col + 1, board, res, leftRow, lowerDiagonal, upperDiagonal);

                // Backtrack: remove the queen and unmark the row and diagonals
                board[row][col] = '.';
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[board.length - 1 + col - row] = 0;
            }
        }
    }

    // Helper function to convert the 2D board array into a List of Strings
    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);  // Convert each row into a string
            res.add(s);  // Add the row string to the result list
        }
        return res;
    }

    // Main function to test the N-Queens solver
    public static void main(String args[]) {
        int N = 4;  // We are solving for a 4x4 board (N-Queens problem with N=4)
        List<List<String>> queen = solveNQueens(N);  // Get all valid solutions

        int i = 1;  // Counter to print solution number
        // Loop through each solution
        for (List<String> it: queen) {
            System.out.println("Arrangement " + i);  // Print solution number
            for (String s: it) {
                System.out.println(s);  // Print each row of the board
            }
            System.out.println();  // Print a newline for better readability
            i += 1;  // Increment the counter
        }
    }
}
