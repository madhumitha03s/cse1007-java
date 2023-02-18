// Write a Java program to print the sum of 2nd digit of the given n numbers.

import java.util.*;

class Sum {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Number of input values: ");
        int n = scan.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int num, temp;
            int count = 1;
            System.out.println("Enter input " + (i + 1) + ": ");
            num = scan.nextInt();
            temp = num;
            while (temp / 10 != 0) {
                count++;
                temp /= 10;
            }
            sum += ((num % Math.pow(10, (count - 1))) / (Math.pow(10, (count - 2))));
        }
        System.out.println("\nSum: " + sum);
        scan.close();
    }
}
