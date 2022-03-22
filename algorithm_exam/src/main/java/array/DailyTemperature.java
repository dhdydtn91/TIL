package array;

import java.util.Stack;

public class DailyTemperature {


    public static void main(String[] args) {
        int temperatures[] = {30, 40, 50, 60};
        int[] solve = solve(temperatures);
        for (int i : solve) {
            System.out.println(i);
        }

    }

    // 내가 푼 풀이
    public static int[] solve(int[] temperatures) {
        //for문 풀이
        int result[] = new int[temperatures.length];
        int count = 0;
        for (int i = 0; i < temperatures.length; i++) {
            int maxTemperature = temperatures[i];
            for (int j = i + 1; j < temperatures.length; j++) {
                count++;
                if (maxTemperature < temperatures[j]) {
                    break;
                }
                if (j == temperatures.length - 1 && maxTemperature == temperatures[i]) {
                    count = 0;
                    break;
                }
            }
            result[i] = count;
            count = 0;
        }
        return result;
    }

    // 강의 풀이
    public static int[] solve2(int[] temperatures) {
        //stack문 풀이
        int len = temperatures.length;
        int[] result = new int[len];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }


}
