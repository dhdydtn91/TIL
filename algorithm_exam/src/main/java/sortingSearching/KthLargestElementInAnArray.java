package sortingSearching;

import java.util.*;

public class KthLargestElementInAnArray {

    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k-1];
    }

    public static int findKthLargest_pq(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();

        for(int i : nums){
            pq.offer(i);

            if(pq.size() > k){
                pq.poll();
            }
        }

        return pq.peek();
    }


    public static void main(String[] args) {
        int nums[] = {3,2,1,5,6,4 };
        int k = 2;
    }
}
