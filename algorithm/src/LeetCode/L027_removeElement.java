package LeetCode;

/**
 * L27_removeElement
 *
 * @author kehaoxiong
 * @date 2020/11/10
 */
public class L027_removeElement {
    public static void main(String[] args) {

        int[] arr = new int[]{3, 2, 2, 3};
        System.out.println(removeElement(arr, 3));

    }

    // 直接循环遍历，替换原数组
    public static int removeElement(int[] nums, int val) {

        if (nums == null || nums.length == 0)
            return 0;

        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val)
                nums[k++] = nums[i];
        }
        return k;

    }

    /**
     * 利用双指针
     *
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        if (nums == null || nums.length == 0)
            return 0;

        int i = 0;
        int j = nums.length - 1;
        while (i <= j) {
            if (nums[j] == val) {
                j--;
                continue;
            }
            if (nums[i] == val) {
                nums[i] = nums[j];
                j--;
            }
            i++;
        }
        return j + 1;
    }
}
