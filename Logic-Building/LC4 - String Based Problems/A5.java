package L4;

import java.util.Scanner;

public class A5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String str1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String str2 = sc.nextLine();

        String reverse = "";

        for (int i = str2.length() - 1; i >= 0; i--) {
            reverse += str2.charAt(i);
        }

        String str3 = str1 + reverse;

        System.out.println("Result = " + str3);

        sc.close();
    }
}