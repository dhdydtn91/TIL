package array;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaximumSubarray {

    public static void main(String[] args) {
        int nums[] = {10, 10, -3, 10, 10};
        int solve = solve(nums);
        System.out.println(solve);
    }

    public static int solve(int[] nums) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            if (!pq.isEmpty() && (pq.peek() == nums[i])) {
                pq.poll();
            }
            pq.add(nums[i]);
        }
        result = pq.poll() + pq.poll();
        return result;
    }
}
