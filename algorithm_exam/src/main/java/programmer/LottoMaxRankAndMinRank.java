package programmer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMaxRankAndMinRank {


    public static void main(String[] args) {
        int [] lottos = {
                44,1,0,0,31,25
        };
        int []win_nums = {
                31,10,45,1,6,19
        };
        LottoMaxRankAndMinRank a  = new LottoMaxRankAndMinRank();
        int[] solution = a.solution(lottos, win_nums);
        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int zeroCnt  = 0;
        int winCount = 0;
        int[] answer = new int[2];
        Map<Integer, Integer> map =new HashMap<>();
        for (int lotto : lottos) {
            map.put(lotto, map.getOrDefault(lotto,0)+1);
        }

        for (int win_num : win_nums) {
            map.put(win_num, map.getOrDefault(win_num,0)+1);
            if(map.get(win_num) == 2){
                winCount++;
            }
        }
        zeroCnt = map.get(0);
        answer[0] = getRank(winCount);
        answer[1] = getRank(winCount+zeroCnt);

        return answer;
    }

    public int getRank(int winCount) {
        int rank = 0 ;
        switch (winCount) {
            case 6 :  rank = 1; break;
            case 5 :  rank = 2; break;
            case 4 :  rank = 3; break;
            case 3 :  rank = 4; break;
            case 2 :  rank = 5; break;
            default :  rank = 6; break;
        }
        return rank;
    }
}
