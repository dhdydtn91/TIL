package sortingSearching;

import java.util.Arrays;

public class CoordinateSort {

  public static void main(String[] args) {
    int [][] arr = {{2, 7},
        {1, 3},
        {1, 2},
        {2, 5},
        {3, 6}};
   int [][]res = solution(arr);
    for (int[] re : res) {
      for (int i : re) {
        System.out.println("i = " + i);
      }
    }
  }

  private static int[][] solution(int[][] arr) {
    Arrays.sort(arr, (o1,o2) -> {
      if(o1[0] == o2[0]){
       return o1[1] - o2[1];
      }
      return o1[0] -o2[0];
    });

    return arr;
  }
}

class Point {
  int x ;
  int y;

  public Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}
