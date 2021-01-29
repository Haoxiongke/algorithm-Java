package LeetCode;

/**
 * L088_merge
 *
 * @author kehaoxiong
 * @date 2021/1/27
 */
public class L088_merge {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m + n - 1;
        int p1 = m - 1;
        int p2 = n - 1;

        while (p1 >= 0 && p2 >= 0) {
            nums1[p--] = (nums1[p1] > nums2[p2]) ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }


    public static void main(String[] args) {
        int[] numList1 = {1, 2, 3};
        int[] numList2 = {2, 4, 5};
        //System.out.println(numList2);
        int[] numRetList = new int[numList1.length + numList2.length];
        int i = 0, j = 0, k = 0;
        while (numList1.length > i && numList2.length > j) {
            if (numList1[i] < numList2[j]) {
                numRetList[k] = numList1[i];
                i++;
            } else {
                numRetList[k] = numList2[j];
                j++;
            }

            k++;
        }
        while (i < numList1.length)
            numRetList[k++] = numList1[i++];
        while (j < numList2.length)
            numRetList[k++] = numList2[j++];

        //  add last num.
        for (int n : numRetList) {
            System.out.println(n);
        }
    }

}
