
import java.util.Scanner;

public class BattleshipGame {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);

        // Initialize the game board
        int boardSize = 5;
        char[][] board = new char[boardSize][boardSize];
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = '-';
            }
        }

        // Place the battleship
        int battleshipSize = 3;
        int row = (int) (Math.random() * (boardSize - battleshipSize + 1));
        int col = (int) (Math.random() * (boardSize - battleshipSize + 1));
        for (int i = row; i < row + battleshipSize; i++) {
            board[i][col] = 'B';
        }

        // Play the game
        int numGuesses = 0;
        while (true) {
            // Display the board
            System.out.println("Guess the row and column of the battleship (0-" + (boardSize - 1) + "):");
            for (int i = 0; i < boardSize; i++) {
                for (int j = 0; j < boardSize; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

            // Get the user's guess
            int guessRow = scan.nextInt();
            int guessCol = scan.nextInt();
            numGuesses++;

            // Check if the guess is correct
            if (board[guessRow][guessCol] == 'B') {
                System.out.println("Congratulations! You sank the battleship in " + numGuesses + " guesses.");
                board[guessRow][guessCol] = 'X';
                break;
            } else {
                System.out.println("Sorry, that was a miss.");
                board[guessRow][guessCol] = 'O';
            }
        }

        // Display the final board
        System.out.println("Final board:");
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

        scan.close();
    }
}
