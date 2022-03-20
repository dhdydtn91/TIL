package twopointers;

public class MaxSales {



  public static void main(String[] args) {
    MaxSales a = new MaxSales();
    int k = 3;
    int []arr = {12, 15 , 11, 20, 25, 10, 20 ,19,13, 15};
    int solution = a.solution(arr,k);
    System.out.println("solution = " + solution);
  }

  private int solution(int[] arr, int k) {
    int l  =0 , r = k , max =0 ;
    int m = arr.length;
    int sum = arr[0] + arr[1] + arr[2];
    max = sum;
    while(r < m){
      sum += arr[r++];
      sum -= arr[l++];
      max = Math.max(max, sum);
    }
    return max;
  }
}
