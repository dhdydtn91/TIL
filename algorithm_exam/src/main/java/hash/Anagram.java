package hash;

import java.util.HashMap;
import java.util.Map;

public class Anagram {

  public static void main(String[] args) {
    Anagram anagram = new Anagram();
    int[] arr= {20,12,20,10,23,17,10};
    int K = 5;
    int[] solution = anagram.solution(arr, K);
    for (int i : solution) {
      System.out.println(i);
    }
  }

  private int[] solution(int[] arr, int k) {

     int unit = arr.length - k + 1;
     int ans [] = new int[k];

     for(int i = 0; i +unit <= arr.length ; i++){
       Map<Integer,Integer> map = new HashMap<>();
       for(int j = i ; j < i+ unit ; j++){
         map.put(arr[j], map.getOrDefault(arr[i],0)+1);
         ans[i] = map.size();
       }
     }

     return ans;
  }
}
