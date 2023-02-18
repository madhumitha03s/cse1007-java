// Create a triangle class with appropriate instance variables  
// and methods to determine the type of the triangle. 
// Use appropriate overloaded constructors.

public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    // Constructor to initialize sides of the triangle
    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
    }

    // Method to determine the type of the triangle
    public String getType() {
        if (sideA <= 0 || sideB <= 0 || sideC <= 0) {
            return "Invalid triangle";
        } else if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
            return "Not a triangle";
        } else if (sideA == sideB && sideB == sideC) {
            return "Equilateral triangle";
        } else if (sideA == sideB || sideA == sideC || sideB == sideC) {
            return "Isosceles triangle";
        } else {
            return "Scalene triangle";
        }
    }

    // Overloaded constructor to create an equilateral triangle
    public Triangle(double side) {
        this(side, side, side);
    }

    // Overloaded constructor to create a right triangle
    public Triangle(double sideA, double sideB, String rightAngleSide) {
        if (rightAngleSide.equals("c")) {
            this.sideA = sideA;
            this.sideB = sideB;
            this.sideC = Math.sqrt(sideA * sideA + sideB * sideB);
        } else if (rightAngleSide.equals("b")) {
            this.sideA = Math.sqrt(sideB * sideB - sideA * sideA);
            this.sideB = sideB;
            this.sideC = sideA;
        } else if (rightAngleSide.equals("a")) {
            this.sideA = sideA;
            this.sideB = Math.sqrt(sideA * sideA - sideB * sideB);
            this.sideC = sideB;
        }
    }
}
