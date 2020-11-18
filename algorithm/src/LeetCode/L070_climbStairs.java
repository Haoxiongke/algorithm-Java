package LeetCode;

/**
 * L70_climbStairs
 *
 * @author kehaoxiong
 * @date 2020/11/18
 */
public class L070_climbStairs {

    public static void main(String[] args) {

        // 对数器
        for (int i = 0; i < 100000; i++) {
            int n = (int) (Math.random() * 10000);
            if (climbStairs(n) != climbStairs2(n))
                System.out.println("false" + n);
//            else
//                System.out.println("true:" + n + "-->" + climbStairs(n));
        }
    }

    public static int climbStairs(int n) {

        if (n <= 2)
            return n;

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    public static int climbStairs2(int n) {
        if (n <= 2)
            return n;
        int p = 1, q = 2, temp;
        for (int i = 2; i < n; i++) {
            temp = p + q;
            p = q;
            q = temp;
        }
        return q;

    }
}
