package LeetCode;

/**
 * L053_maxSubArray
 *
 * @author kehaoxiong
 * @date 2020/11/18
 */
public class L053_maxSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray2(arr));
    }

    // 利用动态规划数组保存，每个位置最大的子序和
    // 时间复杂度O(n) 空间复杂度O(n)
    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length < 1)
            return 0;

        int[] dp = new int[nums.length];
        dp[0] = nums[0];

        int max = dp[0];

        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    // 简化：因为只用了前一个元素的值，不需要new一个新的数组
    // 时间复杂度O(n) 空间复杂度O(1)
    public static int maxSubArray2(int[] nums) {
        int sum = 0, max = 0;
        for (int num : nums) {
//            if (sum < 0)  // 当之前的最大子序和小于0，必定降低后面的最大子序和
//                sum = num;
//            else
//                sum += num;
            sum = Math.max(sum + num, num);
            max = Math.max(sum, max);
        }
        return max;
    }

}
