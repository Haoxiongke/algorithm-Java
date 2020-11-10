package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * L350_intersect
 *
 * @author kehaoxiong
 * @date 2020/11/6
 */
public class L350_intersect {

    public static void main(String[] args) {
        int[] arr1 = new int[]{1, 2, 2, 1};
        int[] arr2 = new int[]{2, 2};

        int[] result = intersect2(arr1, arr2);

        for (int i : result) {
            System.out.println(i);
        }
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num1 : nums1) {
            if (map.containsKey(num1))
                map.put(num1, map.get(num1) + 1);
            else
                map.put(num1, 1);
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for (int num2 : nums2) {
            if (map.containsKey(num2)) {
                if (map.get(num2) > 0) {
                    map.put(num2, map.get(num2) - 1);
                    arr.add(num2);
                }
            }
        }

        int[] resultArray = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            resultArray[i] = arr.get(i);
        }

        return resultArray;

    }


    public static int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        ArrayList<Integer> array = new ArrayList<>();

        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j])
                i++;
            else if (nums1[i] > nums2[j])
                j++;
            else {
                array.add(nums1[i]);
                i++;
                j++;
            }
        }

        int[] resultArr = new int[array.size()];

        for (int i = 0; i < array.size(); i++) {
            resultArr[i] = array.get(i);
        }

        return resultArr;

    }
}
