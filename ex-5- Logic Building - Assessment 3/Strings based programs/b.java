import java.util.Scanner;

public class NambiarNumber {

    public static int nnGenerator(String input1) {

        String result = "";
        int i = 0;

        while (i < input1.length()) {

            int digit = input1.charAt(i) - '0';

            int sum = digit;

            boolean odd = (digit % 2 != 0);

            i++;

            while (i < input1.length()) {

                int next = input1.charAt(i) - '0';
                sum += next;

                i++;

                if ((odd && sum % 2 == 0) ||
                    (!odd && sum % 2 != 0)) {
                    break;
                }
            }

            result += sum;
        }

        return Integer.parseInt(result);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        String number = sc.next();

        System.out.println("Nambiar Number: "
                + nnGenerator(number));

        sc.close();
    }
}