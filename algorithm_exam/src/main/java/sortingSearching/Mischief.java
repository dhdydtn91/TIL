package sortingSearching;

import java.util.Arrays;

public class Mischief {

  public static void main(String[] args) {
    int [] arr ={120,125,152,130,135,135,143,127,160};
    int[] solution = solution(arr);
    for (int i : solution) {
      System.out.println("i = " + i);
    }
  }

  private static int[] solution(int[] arr) {
    int result [] = new int [2];
    int idx = 0 ;
    int[] sortedArr = Arrays.copyOf(arr, arr.length);


    Arrays.sort(sortedArr);
    for(int i = 0 ; i < arr.length ; i++){
      if( arr[i] != sortedArr[i]){
        result[idx++] = i+1;
      }
    }
    return  result;
  }
}
