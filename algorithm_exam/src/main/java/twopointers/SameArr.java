package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameArr {

  public static List<Integer> solution(int []arr, int []arr2){

    int l =0 , r=0 ,  n = arr.length , m =arr2.length;
    List<Integer> list = new ArrayList<>();

    Arrays.sort(arr);
    Arrays.sort(arr2);

    while (l < n && r < m){
      if(arr[l] < arr2[r]){
        l++;
      }else if(arr[l] > arr2[r]){
        r++;
      }else{
        list.add(arr[l]);
        r++; l++;
      }
    }
    return list;
  }

  public static void main(String[] args) {
    int [] arr ={1,3,9,5,2};
    int [] arr2 = {3,2,5,7,8};

    List<Integer> solution = solution(arr, arr2);

    for (Integer integer : solution) {
      System.out.println(integer);
    }
  }

}
