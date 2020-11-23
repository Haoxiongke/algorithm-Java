package LeetCode;

import java.util.Arrays;

/**
 * L300_lengthOfLIS
 *
 * @author kehaoxiong
 * @date 2020/11/19
 */
public class L300_lengthOfLIS {
    public static void main(String[] args) {
        int[] arr = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS2(arr));
    }

    // 动态规划 dp[i] 表示以当前元素结尾最大的子序递增序列长度
    // 遍历规则，与之前的每一个元素进行比较，dp[i] = Math.max(dp[j] + 1,dp[i])   j : 0 -> i
    // 时间复杂度O(n^2) 空间复杂度 O(n)
    public static int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
            max = Math.max(max, dp[i]);
        }

        return max;
    }

    // 利用动态规划+二分查找+贪心策略
    // 创建一个数组，数组中保存长度为i，最小尾元素
    public static int lengthOfLIS2(int[] nums) {
        int[] tails = new int[nums.length];

        int max = 0;
        for (int num : nums) {
            int i = 0, j = max;
            while (i < j) {
                int m = i + ((j - i) >> 1);
                if (tails[m] < num) i = m + 1;
                else j = m - 1;
            }
            tails[i] = num;
            if (max == j) max++;
        }

        return max;
    }
}