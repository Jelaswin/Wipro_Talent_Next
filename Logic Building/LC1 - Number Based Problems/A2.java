package L1;

import java.util.Scanner;

public class A2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int count = 0;

        System.out.println("Enter marks of 3 students:");

        for (int i = 1; i <= 3; i++) {
            int mark = sc.nextInt();

            if (mark >= 35) {
                count++;
            }
        }

        System.out.println("Students Passed = " + count);

        sc.close();
    }
}