package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoArrSum {

  public static int[] solution(int []arr, int []arr2){
    int total = arr.length + arr2.length;
    int result[] = new int [total];
    int n = arr.length;
    int m = arr2.length;
    int l=0 , r=0, cnt =0;

    while(n > l && m >r){
      if(arr[l] < arr2[r]){
        result[cnt++] =arr[l++];
      }else if(arr[l] > arr2[r]) {
        result[cnt++] =arr2[r++];
      }else{
        result[cnt++] =arr[l++];
      }
    }
    return result;
  }

  public static void main(String[] args) {
    int [] arr ={1,3,9,5,2};
    int [] arr2 = {3,2,5,7,8};
    int[] solution = solution(arr, arr2);
    for (int i : solution) {
      System.out.println(i);
    }
  }
}
