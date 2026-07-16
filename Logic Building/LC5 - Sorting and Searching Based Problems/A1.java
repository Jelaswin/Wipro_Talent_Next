package L5;

import java.util.Scanner;

public class A1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] arr = new int[10];

        System.out.println("Enter 10 integers:");

        for (int i = 0; i < 10; i++)
            arr[i] = sc.nextInt();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9 - i; j++) {

                if (arr[j] < arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println("Descending Order:");

        for (int x : arr)
            System.out.print(x + " ");

        sc.close();
    }
}
