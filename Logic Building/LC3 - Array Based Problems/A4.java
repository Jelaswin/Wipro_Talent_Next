package L3;

import java.util.Scanner;

public class A4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] marks = new int[30];
        int[] count = new int[101]; 

        System.out.println("Enter marks of 3 students:");

        for (int i = 0; i < 3; i++) {
            marks[i] = sc.nextInt();

            if (marks[i] >= 0 && marks[i] <= 100) {
                count[marks[i]]++;
            } else {
                System.out.println("Invalid mark!");
            }
        }

        System.out.println("\nFrequency of Marks:");

        for (int i = 0; i <= 100; i++) {
            if (count[i] > 0) {
                System.out.println(i + " -> " + count[i] + " student(s)");
            }
        }

        sc.close();
    }
}
