package sortingSearching;

import java.util.PriorityQueue;
import java.util.Queue;

public class kClosestPointsToOrigin {

    public static int[][] kCloset(int[][] points,int k){
        Queue<int[]> pq = new PriorityQueue<>((a,b)-> (a[0] * a[0] + a[1] *a[1]) -
                (b[0] * b[0]+ b[1] *b[1]));
        int [][] result = new int[k][2];

        for (int[] ints : points) {
            pq.offer(ints);
        }

        for(int i = 0 ; i<k ; i++){
            result[i] = pq.poll();
        }
        return result;
    }


    public static void main(String[] args) {
        int [][] ex = {{3,3},{5,-1},{-2,4}};
        int k = 2;
        int[][] ints = kCloset(ex, k);

        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.println("i = " + i);
            }
        }
    }
}
