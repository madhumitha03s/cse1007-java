// Create a package Cricket with two classes Batting and Bowling. Batting class
// has a method to compute batting average and Bowling class has a method that
// computes bowling average. Create a class Performance which is not belonging
// to Cricket package. Get the attributes of the cricket player in Performance
// class and find his batting and bowling average.

import java.util.Scanner;
import Cricket.*;

public class Performance {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter player details\n");
        System.out.print("Runs scored: ");
        int runs = scan.nextInt();
        System.out.print("Innings played: ");
        int innings = scan.nextInt();
        System.out.print("Not outs: ");
        int notOuts = scan.nextInt();
        System.out.print("Runs given: ");
        int runsGiven = scan.nextInt();
        System.out.print("Wickets taken: ");
        int wicketsTaken = scan.nextInt();
        System.out.print("Overs bowled: ");
        int oversBowled = scan.nextInt();

        Batting batting = new Batting(runs, innings, notOuts);
        Bowling bowling = new Bowling(runsGiven, wicketsTaken, oversBowled);

        System.out.println("Batting Average: " + batting.getBattingAverage());
        System.out.println("Bowling Average: " + bowling.getBowlingAverage());

        scan.close();
    }
}
