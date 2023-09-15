package bootcamp.example.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TwoCircle {
    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;

        System.out.println(solution(r1, r2));
    }

    // 프로그래머스 lv.2 두 원 사이의 정수 쌍

    public static long solution(int r1, int r2) {
        long answer = 0;
        for (int x = 1; x <= r2; x++) {
            double startBound = Math.sqrt((long) r1 * r1 - (long) x * x);
            double endBound = Math.sqrt((long) r2 * r2 - (long) x * x);
            int startInt = (int) Math.ceil(startBound);
            int endInt = (int) Math.floor(endBound);
            answer += endInt - startInt + 1;
        }
        answer *= 4;

        return answer;
    }
}