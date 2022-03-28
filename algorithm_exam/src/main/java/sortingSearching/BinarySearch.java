package sortingSearching;

import java.util.Arrays;

public class BinarySearch {

  public static void main(String[] args) {
    int arr[] ={23,87,65,12,57,32,99,81};
    int num = 32;
    int solution = solution(arr, num);
    System.out.println("solution = " + solution);
  }

  private static int solution(int[] arr, int num) {
    int res =0;
    int lt =0 ;
    int rt = arr.length-1;

    Arrays.sort(arr);
    while(lt <= rt) {
      int mid = (int)(lt + rt)/2;
     if(arr[mid] == num) {
        res = mid+1;
        break;
      }
      if(arr[mid] > num){
        rt = mid -1;
      }else {
        lt = mid +1;
      }
    }
    return res;
  }
}
