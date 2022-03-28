package sortingSearching;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class LRU {

  public static void main(String[] args) {
    int size = 5;
    int [] arr= {1,2,3,2,6,2,3,5,7};
    int[] solution = solution(arr, size);
    for (int i : solution) {
      System.out.println("i = " + i);
    }
  }

  private static int[] solution(int[] arr, int size) {
    int ans [] = new int[size];
    Queue<Integer> q = new LinkedList<>();

    for(int i = 0 ; i< arr.length ; i++){
      if(!q.isEmpty()) {
        if (q.contains(arr[i])) {
          q.remove(arr[i]);
        }
      }
      q.offer(arr[i]);

      if(q.size() > 5){
        q.poll();
      }
    }

    for(int i = size -1; i >= 0 ; i--){
      ans[i] = q.poll();
    }
    return ans;
  }
}
