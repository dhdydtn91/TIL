package programmer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LargestNumber {

    public String solution(int[] numbers) {
      String answer = "";

      //앞에 있는 숫자가 클 때  그대로 정렬
      //앞에 있는 숫자가 크면 그다음 비교
      String [] stringNum = new String [numbers.length];
      for(int i = 0 ; i < numbers.length ; i++){
        stringNum[i] = String.valueOf(numbers[i]);
      }
      Arrays.sort(stringNum, (o1, o2) -> (o2+o1).compareTo(o1+o2));


      for(int i = 0 ; i < stringNum.length ; i++){
        answer += stringNum[i];
      }
      return answer;
    }


  public static void main(String[] args) {
    LargestNumber a = new LargestNumber();
    String solution = a.solution(new int[]{3, 30, 34, 5, 9});
    System.out.println("solution = " + solution);
  }

}
