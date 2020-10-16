package LeetCode;

import java.util.HashMap;

public class L001_twoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2,7,11,15};
        int[] ints = twoSum(arr, 9);
        for (int i : ints)
            System.out.println(i);
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                return result;
            }
            map.put(nums[i],i);
        }
        return null;
    }
}
