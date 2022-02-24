package twopointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithAtMostTwoDistinctCharacters {

    public static int solve (String s){
        Map<Character , Integer> map = new HashMap<>();

        int l =0 , r = 0 , count =0 , max = 0;

        while(r < s.length()){
            //map 넣는다
            char c = s.charAt(r);
            map.put(c,map.getOrDefault(c,0)+1);

            //새로운 수가 들어오는 경우
            if(map.get(c) == 1){
                count ++;
            }
            r++;
            while(count > 2){
                char a = s.charAt(l);
                map.put(a,map.getOrDefault(a,0)-1);
                l++;
                if(map.get(a) == 0)
                count --;
            }
            max = Math.max(max, r-l);
        }
        return max;
    }

    public static void main(String[] args) {
        //String input = "eceba";
        String input = "ccaabbb";

        System.out.println(solve(input));
    }
}
