package CodingInterviews;

import java.util.Arrays;

public class JZ34 {

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("abcda"));
    }

    public static int FirstNotRepeatingChar(String str) {
        if (str.length() == 0)
            return -1;

        int[] arr = new int[128];

        Arrays.fill(arr, Integer.MAX_VALUE);

        int length = str.length();

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            int Val = arr[c];

            if (Val == Integer.MAX_VALUE)
                arr[c] = i;
            else if (Val != Integer.MIN_VALUE)
                arr[c] = Integer.MIN_VALUE;
        }

        for (int i = 0; i < length; i++) {
            char c = str.charAt(i);
            int Val = arr[c];
            if (Val != Integer.MAX_VALUE && Val != Integer.MIN_VALUE)
                return Val;
        }

        return -1;
    }
}
