package Sort;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 0};
        MergeSort(arr);
        for (int j : arr) {
            System.out.println(j);
        }

    }


    public static void MergeSort(int[] arr) {
        if (arr == null || arr.length < 2)
            return;

        MergeSort(arr, 0, arr.length - 1);

    }

    public static void MergeSort(int[] arr, int start, int end) {

        if (start == end)
            return;

        int mid = start + ((end - start) >> 1);

        MergeSort(arr, start, mid);
        MergeSort(arr, mid + 1, end);
        Merge(arr, start, mid, end);

    }

    public static void Merge(int[] arr, int start, int mid, int end) {

        int[] help = new int[end - start + 1];

        int i = 0;
        int p1 = start;
        int p2 = mid + 1;

        while (p1 <= mid && p2 <= end)
            help[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        while (p1 <= mid)
            help[i++] = arr[p1++];
        while (p2 <= end)
            help[i++] = arr[p2++];

        for (i = 0; i < help.length; i++) {
            arr[start + i] = help[i];
        }

    }
}
