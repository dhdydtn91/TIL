package programmer;

import java.util.Arrays;

public class FileNameSort {

  public static void main(String[] args) {

    String input[] = {"F-5323 4Freedom Fighter", "B-50 4Superfortress", "A-10 2Thunderbolt II",
        "F-14 4Tomcat"};
    FileNameSort fileNameSort = new FileNameSort();
    String[] solution = fileNameSort.solution(input);
    for (String s : solution) {
      System.out.println(s);
    }
  }

  public String[] solution(String[] input) {

    Arrays.sort(input, (a1, a2) -> {
      int[] a1NumIndex = getRangeNumber(a1);
      int[] a2NumIndex = getRangeNumber(a2);
      String a1Head = a1.substring(0, a1NumIndex[0]).toUpperCase();
      String a2Head = a2.substring(0, a2NumIndex[0]).toUpperCase();
      int res = a1Head.compareTo(a2Head);
      return res == 0 ? sortingNum(a1, a2, a1NumIndex, a2NumIndex) : res;
    });

    return input;
  }

  private int sortingNum(String a1, String a2, int[] a1NumIndex, int[] a2NumIndex) {
    String num1 = a1.substring(a1NumIndex[0], a1NumIndex[1] + 1);
    String num2 = a2.substring(a2NumIndex[0], a2NumIndex[1] + 1);
    Integer a = Integer.parseInt(num1);
    Integer b = Integer.parseInt(num2);
    return a.compareTo(b);
  }

  private int[] getRangeNumber(String a1) {
    int[] numberRange = new int[2];
    int min = 99999;
    int max = -99999;
    boolean isflag = false;
    for (int i = 0; i < a1.length(); i++) {
        if(Character.isDigit(a1.charAt(i))){
            min = Math.min(i, min);
            max = Math.max(i, max);
            isflag = true;
        }else if(!Character.isDigit(a1.charAt(i)) && isflag){
          break;
        }
    }
    numberRange[0] = min;
    numberRange[1] = max;

    return numberRange;
  }
}
