package sortingSearching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeInterval {

    public static int[][] solve(int[][] intervals){

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);

        ArrayList<int[]> list =new ArrayList<>();
        int arrIndex = 0;
        for(int i = 0 ; i<intervals.length ; i++){
            if(i == 0){
                list.add(intervals[i]);
            }else if( list.get(arrIndex)[1] < intervals[i][0]){
                list.add(intervals[i]);
                arrIndex++;
            }else{
                if(list.get(arrIndex)[1] < intervals[i][1]){
                    int[] setArray = list.get(arrIndex);
                    setArray[1] =intervals[i][1];
                    list.set(arrIndex, setArray) ;
                }
            }
        }

        int[][] result = list.toArray(new int[list.size()][2]);
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,4},{2,6},{8,10},{9,10},{15,18},{18,20}};
      //  int[][] intervals = {{1,5}, {5,6}};
        int[][] solve = solve(intervals);
        for (int[] ints : solve) {
            for (int anInt : ints) {
                System.out.println("anInt = " + anInt);
            }
        }
    }
}
