package twopointers;

public class ContinuousSubsequence {

  public static void main(String[] args) {
    int [] arr ={1,2,1,3,1,1,1,2};
    int k = 6 ;
    ContinuousSubsequence cs = new ContinuousSubsequence();
    int res = cs.solution(arr, k);
    System.out.println("res = " + res);
  }

  private int solution(int[] arr, int k) {
    int l =0,  r= 0;
    int sum = arr[r++];
    int count = 0;
    while (r < arr.length){
     if(sum < k){
       sum += arr[r++];
     }else if (sum > k){
         sum -= arr[l++];
     }else {
       count++;
       sum -= arr[l++];
     }
    }

    return count;
  }
}
