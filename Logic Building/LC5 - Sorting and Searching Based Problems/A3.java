package L5;

import java.util.Scanner;

public class A3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[25];

        System.out.println("Enter 25 integers:");

        for (int i = 0; i < 25; i++)
            arr[i] = sc.nextInt();

        int max = arr[0];
        int first = 0;
        int last = 0;

        for (int i = 1; i < 25; i++) {

            if (arr[i] > max) {
                max = arr[i];
                first = i;
                last = i;
            } else if (arr[i] == max) {
                last = i;
            }
        }

        System.out.println("Maximum = " + max);
        System.out.println("First Position = " + first);
        System.out.println("Last Position = " + last);

        sc.close();
    }
}
