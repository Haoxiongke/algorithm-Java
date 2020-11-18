package LeetCode;

import java.util.ArrayList;
import java.util.Collections;

public class L4_findMedianSortedArrays {
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 2};
        int[] num2 = new int[]{3, 4};
        System.out.println(findMedianSortedArrays4(num1, num2));
    }

    /**
     * 暴力合并，取中位数。 时间复杂度O(m+n),空间复杂度O(m+n)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        ArrayList<Integer> list = new ArrayList<>();
        if (nums1 != null || nums1.length != 0) {
            for (int num : nums1)
                list.add(num);
        }

        if (nums2 != null || nums2.length != 0) {
            for (int num : nums2)
                list.add(num);
        }

        Collections.sort(list);

        return (list.size() % 2 == 1) ? list.get(list.size() / 2) : (list.get(list.size() / 2) + list.get(list.size() / 2 - 1)) * 1.0 / 2;

    }

    /**
     * 用两个指针遍历两个数组，只取中位数。时间复杂度为O(m+n),空间复杂度为O(1)
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = -1, right = -1;
        int astart = 0, bstart = 0;
        int len = m + n;
        for (int i = 0; i <= len / 2; i++) {
            left = right;
            if (astart < m && (bstart >= n || nums1[astart] < nums2[bstart]))
                right = nums1[astart++];
            else
                right = nums2[bstart++];
        }

        if ((len & 1) == 0) {
            return (left + right) / 2.0;
        } else
            return right;
    }

    /**
     * 利用分割算法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays3(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays3(nums2, nums1);
        }

        int len1 = nums1.length;
        int len2 = nums2.length;
        for (int partitions1 = 0; partitions1 <= len1; partitions1++) {
            int partitions2 = (len1 + len2 + 1) / 2 - partitions1;

            int maxLeft1 = (partitions1 == 0) ? Integer.MIN_VALUE : nums1[partitions1 - 1];
            int minright1 = (partitions1 == len1) ? Integer.MAX_VALUE : nums1[partitions1];

            int maxLeft2 = (partitions2 == 0) ? Integer.MIN_VALUE : nums2[partitions2 - 1];
            int minright2 = (partitions2 == len2) ? Integer.MAX_VALUE : nums2[partitions2];

            if (maxLeft1 <= minright2 && maxLeft2 <= minright1) {
                if (((len1 + len2) & 1) == 0)
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minright1, minright2)) / 2.0;
                else
                    return Math.max(maxLeft1, maxLeft2);
            }

        }

        throw new IllegalArgumentException();
    }

    /**
     * 利用二分查找的思路
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays4(int[] nums1, int[] nums2) {

        if (nums1.length > nums2.length)
            return findMedianSortedArrays4(nums2, nums1);

        int low = 0;
        int high = nums1.length;

        int len1 = nums1.length;
        int len2 = nums2.length;

        while (low <= high) {

            int partition1 = (low + high) / 2;
            int partition2 = (len1 + len2 + 1) / 2 - partition1;

            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == len1) ? Integer.MAX_VALUE : nums1[partition1];

            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == len2) ? Integer.MAX_VALUE : nums2[partition2];

            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                if (((len1 + len2) & 1) == 0)
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                else
                    return Math.max(maxLeft1, maxLeft2);
            } else if (maxLeft1 > minRight2)
                high = partition1 - 1;
            else
                low = partition1 + 1;

        }

        throw new IllegalArgumentException();
    }
}
