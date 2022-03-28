package sortingSearching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DuplicationCheck {

  public static void main(String[] args) {
    int [] arr= {20, 25, 52, 30, 39 ,33, 43, 33};
    String solution = solution2(arr);
    System.out.println("solution = " + solution);
  }

  private static String  solution(int[] arr) {
    String ans = "U";
    Map<Integer,Integer> map = new HashMap();

    for(int i= 0 ; i < arr.length ;i++){
      map.put(arr[i],map.getOrDefault(arr[i],0) +1);

      if(map.get(arr[i]) == 2){
        ans = "D";
        break;
      }
    }

    return ans;
  }

  private static String  solution2(int[] arr) {
    String ans = "U";

    Arrays.sort(arr);

    for(int i = 0 ; i<arr.length; i++){
      if(arr[i] == arr[i+1]){
        return ans = "D";
      }
    }

    return ans;
  }
}
