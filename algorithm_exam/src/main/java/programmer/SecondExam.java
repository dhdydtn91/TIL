package programmer;

import java.util.Stack;

public class SecondExam {

  public static void main(String[] args) {
    SecondExam s2  = new SecondExam();
    String s = "{([()]))}";
    int solution = s2.solution(s);
    System.out.println("solution = " + solution);
  }

  public int solution(String s) {
    int answer = 0;
    String [] a= { "{", "[","(",")","]","}"};

    for(int i = 0 ;i< a.length;i++){
      String str = a[i];
      int l = 0;
      while(l <= s.length()){
        String s1 = s.substring(0,l) + str  + s.substring(l, s.length());
        if(isValid(s1)) {
          answer++;
        }
        l++;
      }
    }
    return answer;
  }

  private boolean isValid(String str) {
    final String opening = "({[", closing = ")}]";
    Stack<Character> openStack = new Stack<>();
    for (int i = 0; i < str.length(); i++) {
      if (opening.indexOf(str.charAt(i)) != -1) {
        openStack.push(str.charAt(i));
      } else {
        if (openStack.empty()) return false;
        if (opening.indexOf(openStack.peek()) != closing.indexOf(str.charAt(i)))
          return false;
        openStack.pop();
      }
    }
    return openStack.empty();
  }

  private void pop(Stack<String> stack, String substring) {
    String peek = stack.peek();
    if ("]".equals(substring)) {
      if("[".equals(peek)){
        stack.pop();
      }else {
        stack.push(substring);

      }
    } else if ("}".equals(substring)) {
      if("{".equals(peek)){
        stack.pop();
      }else{
        stack.push(substring);

      }
    } else if (")".equals(substring)) {
      if("(".equals(peek)){
        stack.pop();
      }else{
        stack.push(substring);
      }
    }
  }


}
