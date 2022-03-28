package stackque;

import java.util.Stack;

public class RemoveParentheses {

  public static void main(String[] args) {
    String str = "(A(BC)D)EF(G(H)(IJ)K)LN(N)";
    RemoveParentheses a = new RemoveParentheses();
    String solution = a.solution(str);
    System.out.println(solution);
  }

  private String solution(String str) {
    String anw = "";
    Stack<Character> stack = new Stack<>();
    for(char a :str.toCharArray()){
      if(a == ')') {
        while (true) {
          Character pop = stack.pop();
          if (pop == '(') {
            break;
          }
        }
      }else{
        stack.push(a);
      }
    }

    for(int i = 0; i< stack.size(); i++){
      anw += stack.get(i);
    }
    return anw;
  }
}
