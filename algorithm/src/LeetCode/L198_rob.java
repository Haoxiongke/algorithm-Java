package LeetCode;

/**
 * L198_rob
 *
 * @author kehaoxiong
 * @date 2020/11/24
 */
public class L198_rob {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 1, 2};
        System.out.println(rob2(arr));
    }

    public static int rob(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int len = nums.length;
        int[][] dp = new int[2][len];

        dp[0][0] = 0;
        dp[1][0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = Math.max(dp[1][i - 1], dp[0][i - 1]);
            dp[1][i] = dp[0][i - 1] + nums[i];
        }

        return Math.max(dp[0][len - 1], dp[1][len - 1]);
    }

    public static int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;

        int steal = nums[0];
        int unSteal = 0;

        for (int i = 1; i < nums.length; i++) {
            int temp = unSteal;
            unSteal = Math.max(steal, unSteal);
            steal = temp + nums[i];
        }

        return Math.max(steal, unSteal);
    }
}
