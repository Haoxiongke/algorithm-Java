package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class L003_lengthOfLongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring3("abcabcbb"));
    }

    /**
     * 利用滑动窗口实现
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() == 1) return 1;

        int pre = 0, end = 0;
        StringBuilder sb = new StringBuilder();
        int length = 0;
        while (end < s.length()) {
            char currCh = s.charAt(end);
            if (sb.indexOf(String.valueOf(currCh)) == -1) {
                sb.append(currCh);
                end++;
                length = Math.max(length, end - pre);
            } else {
                pre = s.indexOf(currCh, pre) + 1;
                sb.delete(0, sb.length() - (end - pre));
            }
        }

//        if (length < end - pre)
//            length = end - pre;

        return length;
    }

    /**
     * 暴力解决，超时
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int ans = 0;//保存当前得到满足条件的子串的最大值
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++) //之所以 j<= n，是因为我们子串是 [i,j),左闭右开
                if (allUnique(s, i, j)) ans = Math.max(ans, j - i);//更新 ans
                else break;
        return ans;
    }

    public static boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();//初始化 hash set
        for (int i = start; i < end; i++) {//遍历每个字符
            Character ch = s.charAt(i);
            if (set.contains(ch)) return false; //判断字符在不在 set 中
            set.add(ch);//不在的话将该字符添加到 set 里边
        }
        return true;
    }


    /**
     * 通过hashmap存储下标，存储是需要跳转的下标
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);  // 取max的原因是因为，防止没有更新的字符下标比i小，例如"abba"
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);//下标 + 1 代表 i 要移动的下个位置
        }
        return ans;
    }

    /**
     * 因为字符固定，可以直接创建一个数组保存对应的下标
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring4(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {

            i = Math.max(index[s.charAt(j)], i); // 如果没有该字符，取的是0，不影响结果

            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;//下标 + 1 代表 i 要移动的下个位置
        }
        return ans;
    }


}
