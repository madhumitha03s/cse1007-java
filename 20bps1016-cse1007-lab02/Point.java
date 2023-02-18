// Create point class and provide method to compute the distance between 2 points. 
// Use appropriate overloaded constructors.

public class Point {
    private double x;
    private double y;

    // Constructor to initialize the points
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    // Method to compute the distance
    public double Distance(double x, double y) {
        double distance = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return distance;
    }
}
