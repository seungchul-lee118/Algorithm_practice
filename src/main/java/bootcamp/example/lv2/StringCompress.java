package bootcamp.example.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class StringCompress {
    public static void main(String[] args) {
        String s1 = "aabbaccc";
        String s2 = "ababcdcdababcdcd";
        String s3 = "abcabcdede";
        String s4 = "abcabcabcabcdededededede";
        String s5 = "xababcdcdababcdcd";

        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
        System.out.println(solution(s4));
        System.out.println(solution(s5));
    }

    // 프로그래머스 lv.2 문자열 압축

    public static int solution(String s) {
        int answer = s.length();
        int splitUnit = s.length() / 2;

        while (splitUnit > 0) {
            Stack<String> units = new Stack<>();
            int maxUnitCount = s.length() / splitUnit;
            for (int i = 0; i < maxUnitCount; i++) {
                if ((i + 1) * splitUnit <= s.length()) {
                    String unit = s.substring(splitUnit * i, splitUnit * (i + 1));
                    units.push(unit);
                }
            }
            String recentUnit = units.pop();
            int tempAnswer = s.length();
            int count = 1;
            boolean isSame = false;

            while (!units.isEmpty()) {
                String nextUnit = units.pop();
                if (nextUnit.equals(recentUnit)) {
                    isSame = true;
                    count++;
                } else {
                    if (isSame) {
                        isSame = false;
                        tempAnswer -= splitUnit * (count - 1) - Math.log10(count) - 1;
                        count = 1;
                    }
                }
                recentUnit = nextUnit;
            }
            if (isSame) {
                tempAnswer -= splitUnit * (count - 1) - Math.log10(count) - 1;
            }
            answer = Math.min(answer, tempAnswer);
            splitUnit--;
        }
        return answer;
    }
}
