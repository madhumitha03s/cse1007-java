// Solve Eight Queen's problem using java.

public class EightQueens {

    // Define the board size and number of queens
    private static final int boardSize = 8;
    private static final int numQueens = 8;

    // Initialize the board and solution array
    private static int[][] board = new int[boardSize][boardSize];
    private static int[] solution = new int[numQueens];

    public static void main(String[] args) {
        // Initialize the board
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = 0;
            }
        }

        // Solve the problem
        if (solveQueens(0)) {
            // Print the solution
            for (int i = 0; i < numQueens; i++) {
                System.out.println("(" + i + ", " + solution[i] + ")");
            }
        } else {
            System.out.println("No solution found.");
        }
    }

    // Recursive function to solve the problem
    private static boolean solveQueens(int col) {
        // Base case: all queens have been placed
        if (col == numQueens) {
            return true;
        }

        // Try placing the queen in each row of the current column
        for (int i = 0; i < boardSize; i++) {
            if (isSafe(i, col)) {
                board[i][col] = 1;
                solution[col] = i;
                if (solveQueens(col + 1)) {
                    return true;
                }
                board[i][col] = 0;
            }
        }

        return false;
    }

    // Check if it is safe to place a queen in the given position
    private static boolean isSafe(int row, int col) {
        int i, j;

        // Check this row on left side
        for (i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on left side
        for (i = row, j = col; j >= 0 && i < boardSize; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }
}
