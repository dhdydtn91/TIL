package sortingSearching;

public class BubbleSort {


  public static void main(String[] args) {

    int input[] = {13,5,11,7,23,15};
    int[] solution = solution(input);
    for (int i : solution) {
      System.out.println(i);
    }
  }
//13,5,11,7,23,15
  //13,5,11,7,23,15
  public static int[] solution(int[] input) {
    for (int i = 0; i < input.length -1; i++){
      for(int j = 0; j < input.length -i-1 ; j++){
        if(input[j] > input[j+1]){
          int temp = input[j];
          input[j] = input[j+1];
          input[j+1] = temp;
        }
      }
    }
    return input;
  }
}
