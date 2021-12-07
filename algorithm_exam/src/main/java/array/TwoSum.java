package array;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] solve(int[] nums, int target) {
        int result[] = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length ; i++) {
            if(map.containsKey(nums[i])){
                int val = map.get(nums[i]);
                result[0] = val;
                result[1] = i;
            }else{
                map.put(target - nums[i] , i);
            }
        }
        return result;
    }
    public static void main(String[] args) {
        int nums[] = {2, 8, 11, 14};
        int target = 16;
        int[] solve = solve(nums, target);
        for (int i : solve) {
            System.out.println(i);
        }

    }
}
