package LeetCode;

/**
 * L028_strStr
 *
 * @author kehaoxiong
 * @date 2020/11/24
 */
public class L028_strStr {
    public static void main(String[] args) {
        System.out.println(strStr2("mississippi", "issip"));
    }

    // 暴力求解，每次挪动一位，按位比较
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle))
            return 0;
        if ("".equals(haystack))
            return -1;

        char[] haystackChar = haystack.toCharArray();
        char[] needleChar = needle.toCharArray();
        int i = 0, j = 0, k = 0;

        while (j < haystack.length()) {
            if (haystackChar[j] == needleChar[k]) {
                k++;
                j++;
            } else {
                j=++i;
                k = 0;
                continue;
            }
            if (k == needleChar.length)
                return i;
        }
        return -1;
    }

    // 利用kmp算法求解
    public static int strStr2(String haystack, String needle) {
        if ("".equals(needle))
            return 0;
        if ("".equals(haystack))
            return -1;

        int[] next = next(needle);

        int i = 0; // 指向haystack数组
        int j = 0; // 指向needle并且指向前缀数组

        for (; i < haystack.length(); i++) {
            while (haystack.charAt(i) != needle.charAt(j) && j > 0) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
                if (j == needle.length())
                    return i - needle.length() + 1;
            }
        }

        return -1;
    }

    // 求next数组，也就是前缀数组
    public static int[] next(String str) {
        int[] next = new int[str.length()];
        next[0] = 0;
        int i = 0;
        for (int j = 1; j < str.length(); j++) {
            while (str.charAt(i) != str.charAt(j) && i > 0) {
                i = next[i - 1];
            }
            if (str.charAt(i) == str.charAt(j)) {
                i++;
            }
            next[j] = i;
        }
        return next;
    }
}
