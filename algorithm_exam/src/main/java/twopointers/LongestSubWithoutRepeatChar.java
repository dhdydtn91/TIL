package twopointers;

import java.util.HashMap;
import java.util.Map;

public class LongestSubWithoutRepeatChar {

    public static void main(String[] args) {
        String input = "pawwkea";
       // String input = "abcabcd";
        System.out.println(solve_map(input));
    }

    public static int solve_map(String s) {
        //1. ds
        Map<Character, Integer> map = new HashMap<>();
        int l = 0 , r = 0 , counter = 0, max = 0;

        while (r < s.length()){
            char c = s.charAt(r);
            map.put(c , map.getOrDefault(c,0)+1);
            if(map.get(c) > 1){
                counter++;
            }
            r++;
            while( counter > 0){
                char c1 = s.charAt(l);
                if(map.get(c1) > 1){
                    counter--;
                }
                map.put(c1, map.getOrDefault(c1,0) - 1);
                l++;
            }
            max = Math.max(max, r-l);
        }
        return max;
    }


}
