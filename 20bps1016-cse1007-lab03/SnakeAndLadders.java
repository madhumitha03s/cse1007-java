// Implement snake and game using Java arrays.

import java.util.*;

public class SnakeAndLadders {
    private static final int boardSize = 100;
    private static final int[] snakePositions = { 14, 19, 45, 67, 88, 93 };
    private static final int[] snakeTails = { 7, 3, 26, 51, 33, 71 };
    private static final int[] ladderPositions = { 5, 17, 31, 47, 63, 82 };
    private static final int[] ladderTops = { 25, 62, 78, 84, 96, 89 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPlayers = 2;
        int[] playerPositions = new int[numPlayers];
        Arrays.fill(playerPositions, 0);
        int currentPlayer = 0;

        while (true) {
            System.out.println("Player " + (currentPlayer + 1) + "'s turn. Press enter to roll the dice.");
            scanner.nextLine();
            int roll = rollDice();
            playerPositions[currentPlayer] += roll;

            if (playerPositions[currentPlayer] >= boardSize) {
                System.out.println("You rolled a " + roll + ".");
                System.out.println("\nPlayer " + (currentPlayer + 1) + " has won!");
                break;
            } else {
                System.out.println(
                        "You rolled a " + roll + " and moved to square " + playerPositions[currentPlayer] + ".");

                for (int i = 0; i < snakePositions.length; i++) {
                    if (playerPositions[currentPlayer] == snakePositions[i]) {
                        playerPositions[currentPlayer] = snakeTails[i];
                        System.out.println("Oh no! You landed on a snake. Go back to square "
                                + playerPositions[currentPlayer] + ".");
                        break;
                    }
                }

                for (int i = 0; i < ladderPositions.length; i++) {
                    if (playerPositions[currentPlayer] == ladderPositions[i]) {
                        playerPositions[currentPlayer] = ladderTops[i];
                        System.out.println("Yay! You landed on a ladder. Climb up to square "
                                + playerPositions[currentPlayer] + ".");
                        break;
                    }
                }

                if (roll != 6) {
                    currentPlayer = (currentPlayer + 1) % numPlayers;
                } else {
                    System.out.println("You rolled a 6! Roll again.");
                }
            }
        }

        scanner.close();
    }

    private static int rollDice() {
        Random random = new Random();
        return random.nextInt(6) + 1;
    }
}
