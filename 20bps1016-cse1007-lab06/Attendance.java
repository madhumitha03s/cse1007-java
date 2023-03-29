// Ms. Marple is a school teacher. Create a Java application for her to enter the attendance of students. 
// Assume there are 50 students in the class. Fetch the attendance of each student as “Present” or “Absent”. 
// Write a check() method that takes attendance as argument and displays number of students 
// present and absent on that day. If Ms. Marple enters attendance status other than 
// “Present” or “Absent” the check() method must throw a custom exception “WrongAttendanceException”. 
// Handle the custom exception in the driver class.

import java.util.Scanner;

public class Attendance {
    private String[] attendance;

    public Attendance() {
        attendance = new String[50];
    }

    public void takeAttendance() {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 50; i++) {
            System.out.print("Enter attendance for student " + (i + 1) + " (Present/Absent): ");
            String status = scan.nextLine().toLowerCase();
            if (status.equals("present") || status.equals("absent")) {
                attendance[i] = status;
            } else {
                try {
                    throw new WrongAttendanceException("Invalid attendance status entered.");
                } catch (WrongAttendanceException e) {
                    System.out.println(e.getMessage());
                    attendance[i] = "invalid";
                }
            }
        }
        scan.close();
    }

    public void check() {
        int present = 0;
        int absent = 0;
        for (int i = 0; i < 50; i++) {
            if (attendance[i] != null && attendance[i].equals("present")) {
                present++;
            } else if (attendance[i] != null && attendance[i].equals("absent")) {
                absent++;
            }
        }
        System.out.println("Number of students present: " + present);
        System.out.println("Number of students absent: " + absent);
    }

    public static void main(String[] args) {
        Attendance attendance = new Attendance();
        attendance.takeAttendance();
        attendance.check();
    }
}

class WrongAttendanceException extends Exception {
    public WrongAttendanceException(String message) {
        super(message);
    }
}
