package sortingSearching;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MeetingRoom2 {

    public static int solve(int[][] intervals) {
        if (intervals == null | intervals.length == 0)
            return 0;

        int roomCnt = 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                roomCnt++;
            }
        }
        return roomCnt;
    }


    public static int solve_pq(int[][] intervals) {
        if (intervals == null | intervals.length == 0)
            return 0;

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        for (int[] arr : intervals) {
            if (pq.isEmpty()) {
                pq.offer(arr);
            } else {
                if (pq.peek()[1] <= arr[0]) {
                    pq.poll();
                }
                pq.offer(arr);
            }
        }
        return pq.size();
    }

    public static void main(String[] args) {
        // int intervals [][] = {{5,10}, {16,20}, {0,30}};
        //int intervals [][] = {{6,10}, {1,3}};
        int intervals[][] = {{5, 10}, {16, 20}, {0, 30}, {1, 15}, {31, 45}, {34, 60}};

        int solve = solve_pq(intervals);
        System.out.println("solve = " + solve);
    }
}
