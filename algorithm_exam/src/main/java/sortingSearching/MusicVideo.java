package sortingSearching;

import java.util.Arrays;

public class MusicVideo {

  public static void main(String[] args) {
    int arr[] = {1,2,3,4,5,6,7,8,9};
    int num =3;
    int solution = solution(arr, num);
    System.out.println("solution = " + solution);
  }

  private static int solution(int[] arr, int num) {
    int ans= 0;
    int lt = Arrays.stream(arr).max().getAsInt();
    int rt = Arrays.stream(arr).sum();

    while(lt <= rt){
      int mid = (lt+rt)/2;
      if(count(arr, mid) <= num){
        ans = mid;
        rt=mid-1;
      }else{
        lt= mid+1;
      }

    }
    return ans;
  }

  private static int count(int[] arr, int mid) {
    int count = 1;
    int sum = 0 ;
    for(int i = 0 ; i< arr.length;i++){
      if(sum + arr[i] > mid){
        count++;
        sum =arr[i];
      }else{
        sum+=arr[i];
      }
    }

    return count ;
  }

}
