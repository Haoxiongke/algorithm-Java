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

        if (nums == null || nums.length == 0)
            return 0;

        int k = 1; // nums的第一个元素肯定要放到数组中
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[k++] = nums[i];
            }
        }
        return k;
    }

    /**
     * 利用快慢指针，q指向新元素，p指向不重复元素的末尾
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {

        if (nums == null || nums.length == 0)
            return 0;

        int p = 0;
        int q = 1;
        while (q < nums.length) {
            if (nums[p] != nums[q]) {
                nums[p + 1] = nums[q];
                p++;
            }
            q++;
        }
        return p + 1;
    }
}
