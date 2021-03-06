package com.hyeonah.javalabs.algorithm.top50coding.queueandstack;

import java.util.Stack;

/**
 * Created by hyeonahlee on 2020-12-19.
 *
 * input: "5", "-2", "4", "C", "D", "9", "+", "+"
 * output: 27
 *
 * 5, -2,  (-2*2), 9, ((-2*2)+9), (9+ ((-2*2)+ 9)) = 27
 *
 * C - 마지막 요소 제거 (pop)
 * D - 마지막 요소 * 2
 * + = 마지막 요소 2개 더한 값
 */
public class BaseballGame {

    public static void main(final String[] args) {
        final String[] str = {"5", "-2", "4", "C", "D", "9", "+", "+"};
        System.out.println(solution(str));
    }

    private static int solution(final String[] str) {
        // 1.
        final Stack<Integer> stack = new Stack<>();

        for (final String op : str) {
            if("C".equals(op)) {
                stack.pop();
            } else if("D".equals(op)) {
                stack.push(stack.peek() * 2);
            } else if("+".equals(op)) {
                final int firstPrev = stack.pop();  // 9
                final int secondPrev = stack.pop(); // -4
                stack.push(secondPrev);
                stack.push(firstPrev);
                stack.push(firstPrev + secondPrev);
            } else {
                stack.push(Integer.valueOf(op));
            }
        }
        return stack.stream()
            .mapToInt(Integer::intValue)
            .sum();
    }
}
