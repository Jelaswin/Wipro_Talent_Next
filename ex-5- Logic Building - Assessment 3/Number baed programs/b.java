import java.util.Scanner;

public class AlternateAddSub {

    public static int AddSub(int input1, int input2) {

        int result = input1;

        boolean add;

        if (input2 == 2)
            add = true;
        else
            add = false;

        for (int i = input1 - 1; i >= 1; i--) {

            if (add) {
                result += i;
                add = false;
            } else {
                result -= i;
                add = true;
            }
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        System.out.print("Enter input2 (1 or 2): ");
        int type = sc.nextInt();

        System.out.println("Result after alternate add_sub on N: "
                + AddSub(n, type));

        sc.close();
    }
}