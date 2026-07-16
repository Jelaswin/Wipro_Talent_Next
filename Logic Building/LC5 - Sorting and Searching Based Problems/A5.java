package L5;

import java.util.Scanner;

public class A5 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] a = new int[5];
        int[] b = new int[5];

        System.out.println("Enter 5 elements for Array 1:");

        for (int i = 0; i < 5; i++)
            a[i] = sc.nextInt();

        System.out.println("Enter 5 elements for Array 2:");

        for (int i = 0; i < 5; i++)
            b[i] = sc.nextInt();

        // Sort Array 1
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 - i; j++) {
                if (a[j] < a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

        // Sort Array 2
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4 - i; j++) {
                if (b[j] < b[j + 1]) {
                    int temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
        }

        int[] c = new int[10];

        for (int i = 0; i < 5; i++)
            c[i] = a[i];

        for (int i = 0; i < 5; i++)
            c[i + 5] = b[i];

        System.out.println("Merged Array:");

        for (int x : c)
            System.out.print(x + " ");

        sc.close();
    }
}