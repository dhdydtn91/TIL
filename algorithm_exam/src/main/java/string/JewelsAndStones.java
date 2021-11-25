package string;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {

    public static int solve(String jew, String stones) {
        // 1. 보석의 갯수 부터 확인(중복제거)
        Set<Character> jews = new HashSet<>();
        int count = 0;
        for (int i = 0; i < jew.length(); i++) {
            jews.add(jew.charAt(i));
        }
        // 2. 돌에 보석이 얼마나 있는지 확인
        for (int i = 0; i < stones.length(); i++) {
            char c = stones.charAt(i);
            if (jews.contains(c)) {
                count++;
            }
            ;
        }

        return count;
    }

    public static void main(String[] args) {
        int solve = solve("z", "ZZ");
        System.out.println("solve = " + solve);
    }
}
