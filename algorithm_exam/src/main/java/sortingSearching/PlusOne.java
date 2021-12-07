package sortingSearching;

import java.util.Arrays;

public class PlusOne {

    public static String[] solve(String logs[]) {

        Arrays.sort(logs, (s1, s2) -> {
            String[] split1 = s1.split(" ", 2);
            String[] split2 = s2.split(" ", 2);

            boolean isDig1 = Character.isDigit(split1[1].charAt(0));
            boolean isDig2 = Character.isDigit(split2[1].charAt(0));

            if (!isDig1 && !isDig2) {
                // 모두 문자일때
                int comp = split1[1].compareTo(split2[1]);
                if(comp == 0)
                    return split1[0].compareTo(split2[0]);
                else
                    return comp;
            } else if (isDig1 & isDig2) {
                // 모두 숫자 일때
                return 0;
            } else if (isDig1 && !isDig2) {
                // 첫번째는 숫자 두번쨰는 문자
                return 1;
            } else {
                // 첫번째는 문자 두번째는 숫자
                return -1;
            }
        });
        return logs;
    }

    public static void main(String[] args) {
        String []logs = {"dig1 8 2 3 1",
                "let1 abc cat",
                "dig1 2 5",
                "let2 good dog book",
                "let3 abc zoo"};

        String[] solve = solve(logs);

        for (String s : solve) {
            System.out.println(s);
        }
    }
}
