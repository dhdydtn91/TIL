package programmer;

import java.util.Stack;

public class KaKaoCraneGame {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();
        for(int i= 0 ; i <moves.length ;i++){

            int m = moves[i]-1;
            int n = board.length;

            for(int j = 0 ; j < n ; j++){
                if(board[j][m] != 0){
                    int peek = 0;
                    if(!stack.isEmpty()){
                        peek = stack.peek();
                    }
                    if(peek == board[j][m]){
                        stack.pop();
                        answer += 2;
                    }else{
                        stack.push(board[j][m]);
                    }
                    board[j][m] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int [][] board ={
                 {0,0,0,0,0}
                ,{0,0,1,0,3}
                ,{0,2,5,0,1}
                ,{4,2,4,4,2}
                ,{3,5,1,3,1}};

        int [] moves = {1,5,3,5,1,2,1,4};

        KaKaoCraneGame a  = new KaKaoCraneGame();
        int solution = a.solution(board, moves);
        System.out.println(solution);
    }
}
