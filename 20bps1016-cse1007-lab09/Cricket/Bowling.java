package Cricket;

public class Bowling {
    private int runsGiven;
    private int wicketsTaken;
    private int oversBowled;

    public Bowling(int runsGiven, int wicketsTaken, int oversBowled) {
        this.runsGiven = runsGiven;
        this.wicketsTaken = wicketsTaken;
        this.oversBowled = oversBowled;
    }

    public double getBowlingAverage() {
        if (wicketsTaken == 0) {
            return 0;
        }
        return (double) runsGiven / wicketsTaken;
    }
}
