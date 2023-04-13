// Create a class for a student with name, regno, maths, physics and chemistry
// marks. Create a method to find the total of the three marks. Serialize an
// object of the class and write into a file. Deserialize by reading from the
// file. After deserialization call the total method and display the total.

import java.io.*;

class Student implements Serializable {
    private String name;
    private String regNo;
    private int mathsMarks;
    private int physicsMarks;
    private int chemistryMarks;

    public Student(String name, String regNo, int mathsMarks, int physicsMarks, int chemistryMarks) {
        this.name = name;
        this.regNo = regNo;
        this.mathsMarks = mathsMarks;
        this.physicsMarks = physicsMarks;
        this.chemistryMarks = chemistryMarks;
    }

    public int total() {
        return mathsMarks + physicsMarks + chemistryMarks;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Reg No: " + regNo + ", Maths: " + mathsMarks + ", Physics: " + physicsMarks
                + ", Chemistry: " + chemistryMarks;
    }
}

public class Main    {
    public static void main(String[] args) {
        StudentA student = new StudentA("John Doe", "123456", 80, 75, 90);

        // Serialization
        try {
            FileOutputStream fileOut = new FileOutputStream("student.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(student);
            out.close();
            fileOut.close();
            System.out.println("Serialized data is saved in student.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialization
        StudentA deserializedStudent = null;
        try {
            FileInputStream fileIn = new FileInputStream("student.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            deserializedStudent = (StudentA) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }

        // Display deserialized student details
        System.out.println("Deserialized Student: " + deserializedStudent);

        // Calculate total marks and display
        System.out.println("Total Marks: " + deserializedStudent.total());
    }
}
