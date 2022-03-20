package graph;


public class test {

  public int solution(int[] nums) {
    int answer = 0;
    int l=0, r =l+2;
    int sum = 0;
    for (int i = l ; i<=r ; i++){
      sum += nums[i];
    }
    if(isprime(sum)){
      answer++;
    };
    while (r< nums.length-1){
      r++;
      sum -= nums[l];
      l++;
      sum -= nums[r];
      if(isprime(sum)){
        answer++;
      };

    }

    return answer;
  }

  public boolean isprime(int num){
    int cnt = 0;
    for(int i = 2 ; i <= Math.sqrt(num); i++){
      if(num % i == 0){
        cnt++;
      }
    }
    System.out.println("num : " + num );
    System.out.println("cnt : " + cnt );
    return cnt > 0 ? false: true;
  }
  public static void main(String[] args) {
    test test = new test();
    int nums[] = {1,2,7,6,4};
    int solution = test.solution(nums);
    System.out.println("solution = " + solution);
  }
}
