package CodingInterviews;

import org.junit.Test;

public class JZ37 {

    public static void main(String[] args) {

//        int[] arr = new int[]{1, 2, 3, 3, 4, 4, 5, 6, 6, 6, 6, 6, 7, 8, 9};
        int[] arr = new int[]{1, 1, 2, 2};
        System.out.println(GetNumberOfK(arr, 2));

    }

    public static int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length <= 0)
            return 0;

        int left = binarySearch(array, k);
        int right = binarySearch(array, k + 1); // 右边界为比k大1的数

        return (left == array.length || array[left] != k) ? 0 : right - left;
    }

    public static int binarySearch(int[] array, int k) {

        int low = 0;
        int high = array.length; //防止最后一位是k，找到k+1最左边的index，则为array.length

        while (low < high) {

            int mid = low + ((high - low) >> 1);
            if (array[mid] >= k) {
                high = mid;
            } else
                low = mid + 1;

        }

        return low;

    }
}
