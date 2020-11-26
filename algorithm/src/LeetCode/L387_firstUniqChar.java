package LeetCode;

import org.junit.Test;

import java.util.HashMap;

/**
 * L387_firstUniqChar
 *
 * @author kehaoxiong
 * @date 2020/11/24
 */
public class L387_firstUniqChar {
    public static void main(String[] args) {
        String s = "cc";
        System.out.println(firstUniqChar2(s));
    }

    // 利用HashMap存储元素个数，再遍历一遍，当遇到第一个个数为1的，即返回下标
    public static int firstUniqChar(String s) {

        if (s == null || s.length() == 0)
            return -1;

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            /*if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }*/
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static int firstUniqChar2(String s) {
        if (s == null || s.length() == 0)
            return -1;

        int[] countChar = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            countChar[c - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (countChar[c - 'a'] == 1)
                return i;
        }
        return -1;
    }

    // 一般字符串的题，可以利用26长度的数组来解决
    // 利用数组存储最后出现该字符的下标，再遍历一遍，当下标相同则为第一个元素
    public static int firstUniqChar3(String s) {
        if (s == null || s.length() == 0)
            return -1;

        int[] charIndex = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            charIndex[c - 'a'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            if (charIndex[index] == i)
                return i;
            else
                charIndex[index] = -1;
        }
        return -1;
    }
}
