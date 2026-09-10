import java.util.Scanner;

public class NonPrimeIndexSum {

    public static boolean isPrime(int n) {

        if (n < 2)
            return false;

        for (int i = 2; i * i <= n; i++) {

            if (n % i == 0)
                return false;
        }

        return true;
    }

    public static int sumOfNonPrimeIndexValues(int[] input1, int input2) {

        int sum = 0;

        for (int i = 0; i < input2; i++) {

            if (!isPrime(i))
                sum += input1[i];
        }

        return sum;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        System.out.println("Sum of non-prime index values: "
                + sumOfNonPrimeIndexValues(arr, n));

        sc.close();
    }
}