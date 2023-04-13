// Assume that a text file has names of essay competition participants separated
// by a comma. The name of a participant can have titles Mr. or Ms. Extract each
// name and if the titles are not matching throw and handle a TitleException.
// When an improper title is found display ‘improper title’ and continue
// checking the title. If there is no exception display the count of male and
// female contestants. After which display the total participants if an
// exception occurs or not.

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class TitleException extends Exception {
    TitleException(String message) {
        super(message);
    }
}

public class EssayCompetition {
    public static void main(String[] args) {
        int maleCount = 0;
        int femaleCount = 0;
        int totalCount = 0;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("CSE1007\\LAB 06\\participants.txt"));
            String line = reader.readLine();

            while (line != null) {
                String[] parts = line.split(",");
                for (String name : parts) {
                    name = name.trim();
                    try {
                        if (name.startsWith("Mr.")) {
                            maleCount++;
                        } else if (name.startsWith("Ms.")) {
                            femaleCount++;
                        } else {
                            throw new TitleException("Improper title: " + name);
                        }
                    } catch (TitleException e) {
                        System.out.println(e.getMessage());
                    }
                }
                line = reader.readLine();
            }

            totalCount = maleCount + femaleCount;
            System.out.println("Number of male contestants: " + maleCount);
            System.out.println("Number of female contestants: " + femaleCount);

            reader.close();

        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        } finally {
            System.out.println("Total participants: " + totalCount);
        }
    }
}
