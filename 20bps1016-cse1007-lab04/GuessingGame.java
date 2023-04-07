// Write a java program where a computer guesses a random number between 0-20.
// The player has to keep guessing the number where the computer keeps prompting 
// if the guess is high or low. If a correct guess is made, you win.
// Provide scores as 100 - number of guesses.

import java.util.*;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int score = 100;
        int randomNumber = generateRandomNumber();
        System.out.println("Guess the random number between 0-20!");
        int guess = scan.nextInt();
        while (guess != randomNumber) {
            if (guess < 0 || guess > 20) {
                System.out.println("Please guess a number in the range 0-20. Try again!");
            } else {
                System.out.println("Wrong guess, try again!");
            }
            score -= 1;

            guess = scan.nextInt();
        }
        System.out.println("\nGreat job!");
        System.out.println("The random number is " + randomNumber);
        System.out.println("Your score: " + score);
        scan.close();
    }

    public static int generateRandomNumber() {
        double randomDouble = Math.random() * 20 + 1;
        int randomInt = (int) randomDouble;
        return randomInt;
    }
}
