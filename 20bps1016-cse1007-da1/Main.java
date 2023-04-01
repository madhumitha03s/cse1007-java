package DA1;

public class Main {
    public static void main(String[] args) {
        RegularStudent student1 = new RegularStudent("John", 20, "CS101", "123 Main St, Anytown USA", "2021", 1);
        student1.display();

        DistanceLearningStudent student2 = new DistanceLearningStudent("Jane", 22, "DL101", "456 Main St, Anytown USA",
                "Computer Science");
        student2.display();

    }
}
