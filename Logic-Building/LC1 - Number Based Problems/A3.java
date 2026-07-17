package L1;

import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int positive = 0;
        int negative = 0;

        System.out.println("Enter 5 numbers:");

        for (int i = 1; i <= 5; i++) {
            int num = sc.nextInt();

            if (num < 0)
                negative++;
            else
                positive++;
        }

        System.out.println("Negative Numbers = " + negative);
        System.out.println("Non-Negative Numbers = " + positive);

        sc.close();
    }
}