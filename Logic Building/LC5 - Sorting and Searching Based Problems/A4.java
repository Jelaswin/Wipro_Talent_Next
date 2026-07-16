package L5;

import java.util.Scanner;

public class A4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[15];

        System.out.println("Enter 5 integers:");

        for (int i = 0; i < 5; i++)
            arr[i] = sc.nextInt();

        System.out.print("Enter number to search: ");
        int x = sc.nextInt();

        boolean found = false;

        for (int i = 0; i < 5; i++) {

            if (arr[i] == x) {
                System.out.println("Found at position " + i);
                found = true;
                break;
            }
        }

        if (!found)
            System.out.println("Number not found.");

        sc.close();
    }
}