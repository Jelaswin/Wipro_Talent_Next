package L5;

import java.util.Arrays;

public class A2 {

    public static void main(String[] args) {

        int[] arr = {2,4,2,5,3,4,6,5,1,7};

        Arrays.sort(arr);

        System.out.print("Output: ");

        System.out.print(arr[0] + " ");

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] != arr[i - 1]) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}