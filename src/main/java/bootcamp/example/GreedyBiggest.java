package bootcamp.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Stack;

public class GreedyBiggest {
    public static void main(String[] args) {
        String number1 = "1924";
        String number2 = "1231234";
        String number3 = "4177252841";
        String number4 = "43231";

//        System.out.println(solution(number1, 2));
        System.out.println(solution(number2, 3));
//        System.out.println(solution(number3, 4));
//        System.out.println(solution(number4, 2));
    }

    // 프로그래머스 lv.2 큰 수 만들기
    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < number.length(); i++) {
            int num = number.charAt(i) - '0';
            while (!stack.isEmpty() && stack.peek() < num && k > 0) {
                stack.pop();
                k --;
            }
            stack.push(num);
        }
        for (int i = 0; i < stack.size() - k; i++) {
            answer.append(stack.get(i));
        }

        return answer.toString();
    }
}
