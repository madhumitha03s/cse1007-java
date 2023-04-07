// Solve a tic-tac-toe game using java.

import java.util.Scanner;

public class TicTacToe {

    private char[][] board;
    private char currentPlayer;
    private int movesLeft;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        movesLeft = 9;
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void play() {
        Scanner scan = new Scanner(System.in);
        boolean gameOver = false;
        while (!gameOver) {
            printBoard();
            System.out.println("Player " + currentPlayer + ", enter row (1-3):");
            int row = scan.nextInt() - 1;
            System.out.println("Player " + currentPlayer + ", enter column (1-3):");
            int col = scan.nextInt() - 1;
            if (row < 0 || row >= 3 || col < 0 || col >= 3 || board[row][col] != '-') {
                System.out.println("Invalid move, try again!");
                continue;
            }
            board[row][col] = currentPlayer;
            movesLeft--;
            if (checkWin(row, col)) {
                printBoard();
                System.out.println("Player " + currentPlayer + " wins!");
                gameOver = true;
            } else if (movesLeft == 0) {
                printBoard();
                System.out.println("Game over, it's a draw!");
                gameOver = true;
            } else {
                currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            }
        }
        scan.close();
    }

    private boolean checkWin(int row, int col) {
        // Check row
        if (board[row][0] == board[row][1] && board[row][1] == board[row][2]) {
            return true;
        }
        // Check column
        if (board[0][col] == board[1][col] && board[1][col] == board[2][col]) {
            return true;
        }
        // Check diagonal
        if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[1][1] != '-') {
            return true;
        }
        if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[1][1] != '-') {
            return true;
        }
        return false;
    }

    private void printBoard() {
        System.out.println("-------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
            System.out.println("-------");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}
