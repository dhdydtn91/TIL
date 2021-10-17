package sortingSearching;

import java.util.Arrays;

public class MeetingRoom {

    public static boolean solve(int intervals[][] ){
        if(intervals == null || intervals.length ==0)
            return true;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        for(int i = 0 ; i < intervals.length -1 ; i ++ ){
            if(intervals[i][1] > intervals[i+1][0]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        //int intervals[][] ={{5, 10}, {16, 20}, {0, 30}};
        int intervals[][] = {{7,10},{2,4}};
        boolean solve = solve(intervals);
        System.out.println("solve = " + solve);
    }
}
