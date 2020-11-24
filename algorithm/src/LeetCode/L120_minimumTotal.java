package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * L120_minimumTotal
 *
 * @author kehaoxiong
 * @date 2020/11/23
 */
public class L120_minimumTotal {
    public static void main(String[] args) {

        List<List<Integer>> list = new ArrayList<>();
        List<Integer> list1 = Arrays.asList(2);
        List<Integer> list2 = Arrays.asList(3, 4);
        List<Integer> list3 = Arrays.asList(6, 5, 7);
        List<Integer> list4 = Arrays.asList(4, 1, 8, 3);
        list.add(list1);
        list.add(list2);
        list.add(list3);
        list.add(list4);

        System.out.println(minimumTotal3(list));
    }

    // 解法一：自顶向下，每一层求出最小包含当前元素的最小和
    // 时间复杂度：O(n^2) 空间复杂度O(N^2)
    // 优化方法，因为只用到了上一层的数据，所以只用保存上一层的数据
    public static int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0)
            return 0;

        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];  // 全量存储所有点的最小路径和

        dp[0][0] = triangle.get(0).get(0);

        for (int i = 1; i < n; i++)
            dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);

        for (int i = 1; i < m; i++) {
            int j = 1;
            while (j < triangle.get(i).size() - 1) {
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i).get(j);
                j++;
            }
            dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
        }

        return Arrays.stream(dp[n - 1]).min().getAsInt();
    }

    // 解法二：从底向上，找到最小的路径，最后dp[0][0]即为最小值
    // 时间复杂度 O(n^2) 空间复杂度O(n^2)
    // 优化方案，dp只用到了上一层，故只保存上一层的数
    public static int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;

        int m = triangle.size();
        int n = triangle.get(m - 1).size();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++)
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
        }

        return dp[0][0];
    }

    // 自底向上优化方案
    public static int minimumTotal3(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0)
            return 0;

        int m = triangle.size();

        int[] dp = new int[m + 1];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++)
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
        }

        return dp[0];
    }
}
