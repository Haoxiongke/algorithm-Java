package LeetCode;

import java.util.Arrays;

/**
 * L26_removeDuplicates
 *
 * @author kehaoxiong
 * @date 2020/11/10
 */
public class L26_removeDuplicates {
    public static void main(String[] args) {
        int[] arr = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(removeDuplicates(arr));
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int removeDuplicates(int[] nums) {

        if (nums == null  || nums.length == 0)
            return 0;

        int k = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }
}
