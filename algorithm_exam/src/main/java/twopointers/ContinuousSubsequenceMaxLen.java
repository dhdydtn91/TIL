package twopointers;

import java.util.Arrays;
import java.util.Collections;

public class ContinuousSubsequenceMaxLen {

  public int solution(int [] input , int k){
    int l  = 0 , r= 0 ;
    int max = 0;
    int cnt = 0;
    int m = input.length;

    while (r < m){
      if(input[r] == 0){
        cnt++;
      }
      while(cnt>k){
        if(input[l] ==0) cnt --;
        l++;
      }
      max = Math.max(max, r-l+1);
      r++;
    }

    return max;
  }

  public static void main(String[] args) {
    int [] input = {1,1,0,0,1,1,0,1,1,0,1,1,0,1};
    int k = 2;
    String.valueOf(2);
    ContinuousSubsequenceMaxLen a
         = new ContinuousSubsequenceMaxLen();
  int res = a.solution(input,k);
    System.out.println("res = " + res);



  }

}
