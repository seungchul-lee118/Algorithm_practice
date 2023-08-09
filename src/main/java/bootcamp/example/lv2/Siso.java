package bootcamp.example.lv2;

import java.util.Arrays;

public class Siso {
    public static void main(String[] args) {
        int[] weights = {100, 180, 360, 100, 270};

        System.out.println(solution(weights));
    }

    // 프로그래머스 lv.2 시소 짝꿍

    public static long solution(int[] weights) {
        long answer = 0;
        // 2m, 3m, 4m
        int[] distance = new int[4001];
        int[] real = new int[1001];
        for (int i = 0; i < weights.length; i++) {

            answer += distance[weights[i] * 2];
            answer += distance[weights[i] * 3];
            answer += distance[weights[i] * 4];

            if (real[weights[i]] > 0) {
                answer -= real[weights[i]] * 2L;
            }

            real[weights[i]]++;
            distance[weights[i] * 2]++;
            distance[weights[i] * 3]++;
            distance[weights[i] * 4]++;
        }
        return answer;
    }
}
