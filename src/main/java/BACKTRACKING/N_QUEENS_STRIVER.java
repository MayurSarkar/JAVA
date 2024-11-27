package BACKTRACKING;
import java.util.*;

public class N_QUEENS_STRIVER {
    // Main function to solve N-Queens
    public static List<List<String>> solveNQueens(int n) {
        // Create a board of size n x n filled with '.' (empty spaces)
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';  // Initialize the board with dots
            }
        }

        // A list to store all possible solutions
        List<List<String>> res = new ArrayList<List<String>>();

        // Start the depth-first search (DFS) from column 0
        dfs(0, board, res);

        // Return the list of all valid solutions
        return res;
    }

    // Function to validate whether placing a queen at (row, col) is valid
    static boolean validate(char[][] board, int row, int col) {
        // Save original row and column for backtracking
        int duprow = row;
        int dupcol = col;

        // Check the upper diagonal (left-up direction)
        while (row >= 0 && col >= 0) {
            if (board[row][col] == 'Q') return false;  // If a queen is found, it's invalid
            row--;
            col--;
        }

        // Reset row and col to original values
        row = duprow;
        col = dupcol;

        // Check the left side (same row but previous columns)
        while (col >= 0) {
            if (board[row][col] == 'Q') return false;  // If a queen is found, it's invalid
            col--;
        }

        // Reset row and col to original values again
        row = duprow;
        col = dupcol;

        // Check the lower diagonal (left-down direction)
        while (col >= 0 && row < board.length) {
            if (board[row][col] == 'Q') return false;  // If a queen is found, it's invalid
            col--;
            row++;
        }

        // If no queens found in any direction, it's valid to place the queen here
        return true;
    }

    // The depth-first search (DFS) function to explore all possibilities
    static void dfs(int col, char[][] board, List<List<String>> res) {
        // Base case: if we have placed queens in all columns, add the current board configuration to the result
        if (col == board.length) {
            res.add(construct(board));  // Convert board to a list of strings and add to results
            return;
        }

        // Try placing a queen in every row for the current column
        for (int row = 0; row < board.length; row++) {
            // If it's valid to place the queen at (row, col)
            if (validate(board, row, col)) {
                board[row][col] = 'Q';  // Place the queen
                dfs(col + 1, board, res);  // Move to the next column (recursively)
                board[row][col] = '.';  // Backtrack and remove the queen (for the next iteration)
            }
        }
    }

    // Helper function to convert the 2D board array into a List of Strings
    static List<String> construct(char[][] board) {
        List<String> res = new LinkedList<String>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);  // Convert each row into a string
            res.add(s);  // Add the row as a string to the result list
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
