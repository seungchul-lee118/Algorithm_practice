package bootcamp.example.lv2;

import java.util.Arrays;

public class Dot {
    public static void main(String[] args) {
        int k1 = 2;
        int d1 = 4;
        int k2 = 1;
        int d2 = 5;

        System.out.println(solution(k1, d1));
        System.out.println(solution(k2, d2));
    }

    // 프로그래머스 lv.2 점 찍기

    public static long solution(int k, int d) {
        long answer = 0;
        for (int i = 0; i <= d; i+= k) {
            long y = (long) Math.sqrt(Math.pow(d, 2) - Math.pow(i, 2));
            answer += y / k + 1;
        }
        return answer;
    }
}
