package LeetCode;

/**
 * L096_numTrees
 *
 * @author kehaoxiong
 * @date 2020/12/29
 */
public class L096_numTrees {
    public static int numTrees(int n) {

        if (n == 1 || n == 2)
            return n;

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(5));
    }
}
