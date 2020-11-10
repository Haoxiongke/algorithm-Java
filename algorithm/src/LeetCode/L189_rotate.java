package LeetCode;


import java.util.Arrays;

/**
 * L189_rotate
 *
 * @author kehaoxiong
 * @date 2020/11/10
 */
public class L189_rotate {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        rotate4(arr, 3);
        Arrays.stream(arr).forEach(System.out::println);

    }

    /**
     * 旋转3次
     * 例如1，2，3，4，5，6，7   k = 3
     * 第一次反转  7, 6, 5, 4, 3, 2, 1
     * 在k位置处进行分开反转 5,6,7 , 1,2,3,4
     *
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        k %= nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    private static void reverse(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }

    /**
     * 暴力法 解决旋转问题 时间复杂度为O(n*k),空间复杂度为O(1)
     *
     * @param nums
     * @param k
     */
    public static void rotate2(int[] nums, int k) {
        int temp, previous; // 进行k次移动，用previous记录前一个元素
        for (int i = 0; i < k; i++) { // for循环k次，进行k次移动
            previous = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }

    /**
     * 利用一个新数组  时间复杂度O(n) 空间复杂度O(n)
     *
     * @param nums
     * @param k
     */
    public static void rotate3(int[] nums, int k) {
        int[] newArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArr[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < newArr.length; i++) {
            nums[i] = newArr[i];
        }
    }

    /**
     * 利用位置进行跳跃，追踪到每个元素要移动的位置。然后才停止
     * 时间复杂度O(n) 空间复杂度O(1)
     *
     * @param nums
     * @param k
     */
    public static void rotate4(int[] nums, int k) {

        int count = 0; //利用count统计数组中的元素
        int previous, current, next, temp;
        for (int start = 0; count < nums.length; start++) {
            previous = nums[start];
            current = start;

            do {
                next = (current + k) % nums.length;
                temp = nums[next];
                nums[next] = previous;
                previous = temp;
                current = next;
                count++;
            } while (start != current);
        }

    }
}
