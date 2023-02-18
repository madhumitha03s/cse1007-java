// Write a Java program with a class Greet. It has a static method called disp() 
// that gets the name of the child celebrating some event. Display the name. 
// Create a driver class with a static method gdisp() that fetches the event name like birthday. 
// Print the name of child and event greeting text by calling static methods appropriately.

public class Greet {

    public static void disp(String name) {
        System.out.println(name);
    }

    public class Driver {
        public static void gdisp(String event, String name) {
            System.out.println("Wishing " + name + " a very happy " + event + "!!!");
        }
    }

    public static void main(String[] args) {
        String name = "Madhu";
        String event = "birthday";
        Driver.gdisp(event, name);
    }
}
