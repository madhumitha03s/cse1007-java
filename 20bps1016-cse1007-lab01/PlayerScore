// Write a Java program for the following game: 
// 1. There are 5 rounds and three players. Each player can start the game after rolling 6. 
// 2. Once 6 is rolled and game starts for a player. 
//      If he throws a even value then add the double of even value as score. 
//      If odd add the value and then reverse. 
// 3. Find and display the player number and score of the player who scored maximum. 
// 4. If no one starts the game then print "game over".

import java.util.*;

public class PlayerScore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numRounds = 5;
        int numPlayers = 3;
        int[][] diceRoll = new int[numPlayers][numRounds];
        int[][] scores = new int[numPlayers][numRounds];
        int[] maxScores = new int[numPlayers];
        int maxScorePlayer = -1;

        // Roll dice for each player and calculate their scores for each round
        for (int i = 0; i < numPlayers; i++) {
            boolean gameStarted = false;
            for (int j = 0; j < numRounds; j++) {
                diceRoll[i][j] = scan.nextInt();
                if (diceRoll[i][j] == 6) {
                    gameStarted = true;
                }
                if (gameStarted) {
                    if (diceRoll[i][j] % 2 == 0) {
                        scores[i][j] = scores[i][j - 1] + 2 * diceRoll[i][j];
                    } else {
                        scores[i][j] = reverse(scores[i][j - 1] + diceRoll[i][j]);
                    }
                }
            }
            // Calculate max score and player
            for (int j = 0; j < numRounds; j++) {
                maxScores[i] = Math.max(maxScores[i], scores[i][j]);
            }
            if (maxScores[i] > maxScores[maxScorePlayer]) {
                maxScorePlayer = i;
            }
        }

        if (maxScorePlayer == -1) {
            System.out.println("Game over");
        } else {
            System.out.println("Player " + (maxScorePlayer + 1) + " - Score: " + maxScores[maxScorePlayer]);
        }

        scan.close();
    }

    public static int reverse(int num) {
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        return reversed;
    }
}
