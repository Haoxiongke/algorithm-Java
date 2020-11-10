package LeetCode;

/**
 * L122_maxProfit
 *
 * @author kehaoxiong
 * @date 2020/11/9
 */
public class L122_maxProfit {
    public static void main(String[] args) {
        System.out.println(maxProfit3(new int[]{7, 1, 5, 3, 6, 4}));
    }

    // 利用贪心策略，只有涨的时候才买卖
    public static int maxProfit(int[] prices) {

        if (prices.length < 2)
            return 0;

        int total = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                total += prices[i] - prices[i - 1];
        }

        return total;
    }

    // 利用动态规划
    // dp[i][0] 表示当前天数，不持股，手中的最大现金额  更新策略 dp[i][0] = max(dp[i-1][0],dp[i-1]+price)
    // dp[i][1] 表示当前天数，持股，手中的最大现金额   更新策略 dp[i][1] = max(dp[i-1][1],dp[i-1][0]-price)

    public static int maxProfit2(int[] prices) {

        int[][] dp = new int[prices.length][2];

        dp[0][0] = 0;
        dp[0][1] = -prices[0];


        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];

    }

    // 动态规划 优化，发现当前天数的值只与前一天有关，故只用两个变量存储就够了
    public static int maxProfit3(int[] prices) {

        int dp0 = 0;
        int dp1 = -prices[0];


        for (int i = 1; i < prices.length; i++) {
            dp0 = Math.max(dp0, dp1 + prices[i]);
            dp1 = Math.max(dp1, dp0 - prices[i]);
        }

        return dp0;

    }
}
