package LeetCode;

/**
 * L064_minPathSum
 *
 * @author kehaoxiong
 * @date 2020/11/24
 */
public class L064_minPathSum {
    public static void main(String[] args) {
        int[][] arr = new int[2][3];
        arr[0] = new int[]{1, 2, 3};
        arr[1] = new int[]{4, 5, 6};
//        arr[2] = new int[]{4, 2, 1};

        System.out.println(minPathSum2(arr));
    }

    // 动态规划，遍历计算每个节点的最短路径和
    // 时间复杂度O(m*n) 空间复杂度O(m*n)
    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m = grid.length;
        int n = grid[m - 1].length;

        int[][] dp = new int[m][n];

        // 填充最左边
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        // 填充最上边
        for (int j = 1; j < n; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];

        // 填充其他位置
        // 状态转移方程 dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];

        return dp[m - 1][n - 1];
    }

    // 时间复杂度O(m*n) 空间复杂度O(n)
    public static int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;

        int m= grid.length;
        int n = grid[0].length;

        int[] dp = new int[n]; // 最多只用到上层数据，故减少空间消耗
        dp[0] = grid[0][0];

        // 按层填充，初始化填充第一层
        for (int j = 1; j < n; j++)
            dp[j] = dp[j - 1] + grid[0][j];

        for (int i=1;i<m;i++)
            for (int j = 0; j < n; j++) {
                if (j == 0)
                    dp[j] = dp[j] + grid[i][j];
                else {
                    dp[j] = Math.min(dp[j - 1], dp[j]) + grid[i][j];  // dp[j]是上层计算的结果（对应上到下），dp[j-1]是本层计算的结果（对应左到右）
                }
            }

        return dp[n - 1];
    }
}
