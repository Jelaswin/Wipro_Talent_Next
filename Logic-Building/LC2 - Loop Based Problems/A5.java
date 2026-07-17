package L2;

import java.util.Scanner;

public class A5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int divisor = 2;

        while (divisor <= num) {
            if (num % divisor == 0) {
                System.out.println("Smallest exact divisor = " + divisor);
                break;
            }
            divisor++;
        }

        sc.close();
    }
}