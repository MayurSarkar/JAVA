package BACKTRACKING;

import java.util.*;  // Import utility classes (not directly used here but generally useful for larger programs)
//Good practice to import

class Solution {

    // Main function to solve the Sudoku puzzle using backtracking
    public static boolean solveSudoku(char[][] board) {
        // Loop through the entire Sudoku board
        for (int i = 0; i < 9; i++) {  // i iterates over the rows
            for (int j = 0; j < 9; j++) {  // j iterates over the columns
                // Check if the current cell is empty (represented by '.')
                if (board[i][j] == '.') {

                    // Try placing digits '1' to '9' in the current cell
                    for (char c = '1'; c <= '9'; c++) {
                        // Check if placing digit 'c' in cell (i, j) is valid
                        if (isValid(board, i, j, c)) {
                            board[i][j] = c;  // Place digit 'c' in the current cell

                            // Recursively attempt to solve the rest of the board
                            if (solveSudoku(board))
                                return true;  // If successful, return true to end recursion
                            else
                                board[i][j] = '.';  // Otherwise, backtrack (remove 'c' from the cell)
                        }
                    }

                    // If no valid digit can be placed in this cell, return false to backtrack
                    return false;
                }
            }
        }
        // If the entire board is filled, return true indicating the solution is found
        return true;
    }

    // Helper function to check if placing digit 'c' at (row, col) is valid
    public static boolean isValid(char[][] board, int row, int col, char c) {
        // Check if 'c' already exists in the same column
        for (int i = 0; i < 9; i++) {
            if (board[i][col] == c)  // If 'c' is found in the column, return false
                return false;

            // Check if 'c' already exists in the same row
            if (board[row][i] == c)  // If 'c' is found in the row, return false
                return false;

            // Check if 'c' exists in the same 3x3 subgrid
            // Formula to compute the starting row and col of the 3x3 subgrid:
            // (3 * (row / 3) + i / 3) gives the row inside the subgrid
            // (3 * (col / 3) + i % 3) gives the col inside the subgrid
            if (board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c)
                return false;  // If 'c' is found in the subgrid, return false
        }
        // If no conflicts are found, return true (placing 'c' is valid)
        return true;
    }

    // Main function to test the Sudoku solver
    public static void main(String[] args) {

        // Initialize the board with a partially filled Sudoku puzzle
        char[][] board = {
                {'9', '5', '7', '.', '1', '3', '.', '8', '4'},  // '.' indicates an empty cell
                {'4', '8', '3', '.', '5', '7', '1', '.', '6'},
                {'.', '1', '2', '.', '4', '9', '5', '3', '7'},
                {'1', '7', '.', '3', '.', '4', '9', '.', '2'},
                {'5', '.', '4', '9', '7', '.', '3', '6', '.'},
                {'3', '.', '9', '5', '.', '8', '7', '.', '1'},
                {'8', '4', '5', '7', '9', '.', '6', '1', '3'},
                {'.', '9', '1', '.', '3', '6', '.', '7', '5'},
                {'7', '.', '6', '1', '8', '5', '4', '.', '9'}
        };

        // Call the solveSudoku function to solve the puzzle
        solveSudoku(board);

        // Print the solved Sudoku board
        for (int i = 0; i < 9; i++) {  // Iterate over each row
            for (int j = 0; j < 9; j++) {  // Iterate over each column
                System.out.print(board[i][j] + " ");  // Print the value at (i, j)
            }
            System.out.println();  // Print a new line after each row
        }
    }
}
