package L1;

import java.util.Scanner;

public class A4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        if (num == 0)
            System.out.println("The number is Zero");
        else if (num % 2 == 0)
            System.out.println("The number is Even");
        else
            System.out.println("The number is Odd");

        sc.close();
    }
}