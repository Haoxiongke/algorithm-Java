package LeetCode;

import java.util.Arrays;

/**
 * L66_plusOne
 *
 * @author kehaoxiong
 * @date 2020/11/10
 */
public class L66_plusOne {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] result = plusOne(arr);
        Arrays.stream(result).forEach(System.out::println);
    }

    public static int[] plusOne(int[] digits) {

        if (digits == null || digits.length == 0) {
            return null;
        }

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) return digits;
        }

        int[] arr = new int[digits.length + 1]; // 如果全进位，则new一个新的数组，首位为1，其余全为0
        arr[0] = 1;
        return arr;

    }
}
