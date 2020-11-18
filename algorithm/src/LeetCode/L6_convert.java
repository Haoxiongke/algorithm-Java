package LeetCode;

import java.util.Arrays;

/**
 * L006_convert
 *
 * @author kehaoxiong
 * @date 2020/11/16
 */
public class L6_convert {
    public static void main(String[] args) {
        System.out.println(convert2("LEETCODEISHIRING", 3));
    }

    public static String convert(String s, int numRows) {

        if (numRows == 1)
            return s;

        String[] arr = new String[numRows];
        Arrays.fill(arr, "");

        // 一个周期循环2n-2个元素
        int period = 2 * numRows - 2;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int mod = i % period;
            if (mod < numRows)
                arr[mod] += s.charAt(i);
            else
                arr[period - mod] += s.charAt(i);
        }

        StringBuilder result = new StringBuilder();
        for (String subStr : arr)
            result.append(subStr);
        return result.toString();

    }

    public static String convert2(String s, int numRows) {

        if (numRows == 1)
            return s;

        String[] arr = new String[numRows];
        Arrays.fill(arr, "");

        char[] chars = s.toCharArray();
        int i = 0, flag = -1;  // 利用flag标志是从往上还是往下
        for (char c : chars) {
            arr[i] += c;
            if (i == 0 || i == numRows -1) flag = -flag; // 当为数组第一个或者最后一个反向
            i += flag;
        }

        StringBuilder result = new StringBuilder();
        for (String subStr : arr)
            result.append(subStr);
        return result.toString();

    }
}
