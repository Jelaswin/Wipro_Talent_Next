package L2;

import java.util.Scanner;

public class A3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a decimal number: ");
        int num = sc.nextInt();

        String binary = "";

        while (num > 0) {
            binary = (num % 2) + binary;
            num = num / 2;
        }

        System.out.println("Binary = " + binary);

        sc.close();
    }
}
