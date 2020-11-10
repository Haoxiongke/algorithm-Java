package LeetCode;

/**
 * L014_longestCommonPrefix
 *
 * @author kehaoxiong
 * @date 2020/11/9
 */
public class L014_longestCommonPrefix {
    public static void main(String[] args) {

        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length < 1)
            return "";

        String prefix = strs[0]; // 把第一个元素作为基准

        for (int i = 1; i < strs.length; i++) {
            while (!strs[i].startsWith(prefix))
                if (prefix.length() == 0)
                    return "";
                else {
                    prefix = prefix.substring(0, prefix.length() - 1); // 不满足长度-1
                }
        }

        return prefix;


    }
}
