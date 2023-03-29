// Develop a Java program that displays odd and even numbers alternatively using two threads.

public class OddEvenThread implements Runnable {
    private int startNum;
    private int endNum;
    private boolean isEven;

    public OddEvenThread(int startNum, int endNum, boolean isEven) {
        this.startNum = startNum;
        this.endNum = endNum;
        this.isEven = isEven;
    }

    @Override
    public void run() {
        for (int i = startNum; i <= endNum; i++) {
            if (i % 2 == (isEven ? 0 : 1)) {
                System.out.println(Thread.currentThread().getName() + ": " + i);
            }
        }
    }

    public static void main(String[] args) {
        int start = 1;
        int end = 20;

        Thread t1 = new Thread(new OddEvenThread(start, end, true));
        Thread t2 = new Thread(new OddEvenThread(start, end, false));

        t1.setName("Even Thread");
        t2.setName("Odd Thread");

        t1.start();
        t2.start();
    }
}
