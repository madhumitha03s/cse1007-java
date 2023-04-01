package DA2;

import java.util.*;

class AttendanceException extends Exception {
    public AttendanceException(String message) {
        super(message);
    }
}

class AttendanceManager {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Map<String, String> attendance = new HashMap<>();

        System.out.print("Enter number of students: ");
        int numStudents = input.nextInt();
        input.nextLine(); // Consume newline character

        for (int i = 1; i <= numStudents; i++) {
            System.out.print("Enter name of student " + i + ": ");
            String name = input.nextLine();

            System.out.print("Enter attendance status (P/A) for " + name + ": ");
            String status = input.nextLine();

            attendance.put(name, status);
        }

        int presentCount = 0;
        int absentCount = 0;

        for (Map.Entry<String, String> entry : attendance.entrySet()) {
            String name = entry.getKey();
            String status = entry.getValue();

            try {
                if (!status.equals("P") && !status.equals("A")) {
                    throw new AttendanceException("Invalid attendance entry for " + name);
                }

                if (status.equals("P")) {
                    presentCount++;
                } else {
                    absentCount++;
                }
            } catch (AttendanceException e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Present: " + presentCount);
        System.out.println("Absent: " + absentCount);

        input.close();
    }
}
