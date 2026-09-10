import java.util.Scanner;

public class PalindromeRemoval {

    public static boolean isPalindrome(String s) {

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            if (s.charAt(left) != s.charAt(right))
                return false;

            left++;
            right--;
        }

        return true;
    }

    public static int digitRemove_Palin(int input1) {

        String num = String.valueOf(input1);

        if (isPalindrome(num))
            return -1;

        for (int i = 0; i < num.length(); i++) {

            String temp = num.substring(0, i)
                    + num.substring(i + 1);

            if (isPalindrome(temp))
                return num.charAt(i) - '0';
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number: ");
        int n = sc.nextInt();

        int result = digitRemove_Palin(n);

        if (result == -1)
            System.out.println("No digit needs to be removed / No solution");
        else
            System.out.println(
                "Digit to be removed to form palindrome: " + result);

        sc.close();
    }
}