package LeetCode;

/**
 * L344_reverseString
 *
 * @author kehaoxiong
 * @date 2020/11/24
 */
public class L344_reverseString {
    public static void main(String[] args) {
        char[] str = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(str);
        for (char c : str) {
            System.out.println(c);
        }
    }

    public static void reverseString(char[] s) {
        if(s == null || s.length == 0)
            return;

        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
