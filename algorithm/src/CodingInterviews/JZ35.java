package CodingInterviews;

public class JZ35 {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        System.out.println(InversePairs(arr));
    }


    /**
     * 利用归并排序解决逆序对问题，在归并的时候将大数放在前面。如果左边的数组大于右边的数组，那么逆序对将是右边数组p2到end的长度
     *
     * @param array 输入数组
     * @return 返回逆序对个数，对1000000007取余
     */
    public static int InversePairs(int[] array) {

        if (array == null || array.length < 2)
            return 0;

        return MergeSort(array, 0, array.length - 1) % 1000000007;
    }

    private static int MergeSort(int[] arr, int start, int end) {

        if (start == end)
            return 0;

        int res = 0;
        int mid = start + ((end - start) >> 1);

        res += MergeSort(arr, start, mid);
        res %= 1000000007;
        res += MergeSort(arr, mid + 1, end);
        res %= 1000000007;
        res += Merge(arr, start, mid, end);
        res %= 1000000007;

        return res;
    }

    private static int Merge(int[] arr, int start, int mid, int end) {

        int[] help = new int[end - start + 1];

        int p1 = start;
        int p2 = mid + 1;
        int i = 0;
        int count = 0;

        while (p1 <= mid && p2 <= end) {
            if (arr[p1] > arr[p2]) {
                help[i++] = arr[p1++];
                count = (count + end - p2 + 1) % 1000000007;
            } else
                help[i++] = arr[p2++];
        }
        while (p1 <= mid)
            help[i++] = arr[p1++];
        while (p2 <= end)
            help[i++] = arr[p2++];

        for (i = 0; i < help.length; i++) {
            arr[start + i] = help[i];
        }

        return count;

    }


}
