package Cricket;

public class Batting {
    private int runs;
    private int innings;
    private int notOuts;

    public Batting(int runs, int innings, int notOuts) {
        this.runs = runs;
        this.innings = innings;
        this.notOuts = notOuts;
    }

    public double getBattingAverage() {
        if (innings - notOuts == 0) {
            return 0;
        }
        return (double) runs / (innings - notOuts);
    }
}
