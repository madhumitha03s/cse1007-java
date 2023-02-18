// Write a Java program to generate register number as 22BCEXXXX where XXXX begins with 1000. 
// Generate register number for each student by incrementing XXXX. 
// Use static variable. For each student also display the regno and 
// call a method to display if he/she has passed the exam.

import java.util.Scanner;

public class Student {

    private static int nextRegNo = 1000;
    private int regNo;
    private String name;
    private int marks;

    public Student(String name, int marks) {
        this.regNo = nextRegNo++;
        this.name = name;
        this.marks = marks;
    }

    public String getRegNo() {
        return "22BCE" + String.format("%04d", regNo);
    }

    public String getName() {
        return name;
    }

    public int getMarks() {
        return marks;
    }

    public boolean hasPassed() {
        return marks >= 40;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = scan.nextInt();
        scan.nextLine(); // consume newline
        Student[] students = new Student[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter name of student " + (i + 1) + ": ");
            String name = scan.nextLine();
            System.out.print("Enter marks of student " + (i + 1) + ": ");
            int marks = scan.nextInt();
            scan.nextLine(); // consume newline
            students[i] = new Student(name, marks);
        }
        for (Student student : students) {
            System.out.println("Student: " + student.getName());
            System.out.println("Reg No: " + student.getRegNo());
            System.out.println("Marks: " + student.getMarks());
            if (student.hasPassed()) {
                System.out.println("Result: PASS");
            } else {
                System.out.println("Result: FAIL");
            }
            System.out.println();
        }
        scan.close();
    }
}
