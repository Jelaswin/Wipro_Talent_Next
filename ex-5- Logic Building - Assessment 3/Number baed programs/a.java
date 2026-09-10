import java.util.Scanner;

public class GenerateSeriesNth {

    public static int generateSeriesFindN(int input1, int input2,
                                          int input3, int input4) {

        int diff1 = input2 - input1;
        int diff2 = input3 - input2;

        int result = input1;

        for (int i = 1; i < input4; i++) {
            if (i % 2 == 1)
                result += diff1;
            else
                result += diff2;
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter input1: ");
        int input1 = sc.nextInt();

        System.out.print("Enter input2: ");
        int input2 = sc.nextInt();

        System.out.print("Enter input3: ");
        int input3 = sc.nextInt();

        System.out.print("Enter N: ");
        int input4 = sc.nextInt();

        System.out.println("Nth element of the series: "
                + generateSeriesFindN(input1, input2, input3, input4));

        sc.close();
    }
}