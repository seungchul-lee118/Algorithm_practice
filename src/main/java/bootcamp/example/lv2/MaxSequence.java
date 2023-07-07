package bootcamp.example.lv2;

import java.util.*;
import java.util.stream.Collectors;

public class MaxSequence {
    public static void main(String[] args) {
        String expression1 = "100-200*300-500+20";
        String expression2 = "50*6-3*2";

        System.out.println(solution(expression1));
        System.out.println(solution(expression2));
    }

    // 프로그래머스 lv.2 수식 최대화

    public static long solution(String expression) {
        long answer = 0;

        List<Long> num = Arrays.stream(expression.split("\\D"))
            .map(Long::parseLong).collect(Collectors.toList());
        List<String> cal = new ArrayList<>(Arrays.asList(
            expression.replaceAll("\\d", "")
            .split("")));

        answer = Math.max(answer, calculate(num, cal, "*-+"));
        answer = Math.max(answer, calculate(num, cal, "*+-"));
        answer = Math.max(answer, calculate(num, cal, "+-*"));
        answer = Math.max(answer, calculate(num, cal, "+*-"));
        answer = Math.max(answer, calculate(num, cal, "-+*"));
        answer = Math.max(answer, calculate(num, cal, "-*+"));

        return answer;
    }

    private static long calculate(List<Long> num, List<String> cal, String priority) {
        int idx = 0;

        ArrayList<Long> tempNum = new ArrayList<>(num);
        ArrayList<String> tempCal = new ArrayList<>(cal);

        String[] split = priority.split("");
        String first = split[0];
        String second = split[1];
        String third = split[2];

        while (!tempCal.isEmpty()) {
            if (tempCal.contains(first)) {
                idx = tempCal.indexOf(first);
            } else if (tempCal.contains(second)) {
                idx = tempCal.indexOf(second);
            } else if (tempCal.contains(third)) {
                idx = tempCal.indexOf(third);
            }

            long number1 = tempNum.remove(idx);
            long number2 = tempNum.remove(idx);
            String nowCal = tempCal.remove(idx);
            long result = 0;

            if (nowCal.equals("*")) {
                result = number1 * number2;
            } else if (nowCal.equals("-")) {
                result = number1 - number2;
            } else {
                result = number1 + number2;
            }
            tempNum.add(idx, result);
        }
        return Math.abs(tempNum.get(0));
    }
}
