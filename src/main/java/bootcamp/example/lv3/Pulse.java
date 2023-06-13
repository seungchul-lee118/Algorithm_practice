package bootcamp.example.lv3;

import java.util.Arrays;
import java.util.HashSet;

public class Pulse {
    public static void main(String[] args) {
        int[] sequence = {2, 3, -6, 1, 3, -1, 2, 4};

        System.out.println(solution(sequence));
        System.out.println(solution1(sequence));
    }

    // 프로그래머스 Lv.3 연속 펄스 부분 수열의 합

    public static long solution(int[] sequence) {
        long[] pulse = new long[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            pulse[i] = (long) Math.pow(-1, i) * sequence[i];
            if (i > 0) {
                pulse[i] += pulse[i-1];
            }
        }
        long max = Arrays.stream(pulse).max().getAsLong();
        long min = Arrays.stream(pulse).min().getAsLong();
        if (max * min > 0) {
            return Math.max(Math.abs(max), Math.abs(min));
        }
        return max - min;
    }

    // dp 풀이
    public static long solution1(int[] sequence) {
        long answer = 0;
        long[] pulse1 = new long[sequence.length];
        long[] pulse2 = new long[sequence.length];
        for (int i = 0; i < sequence.length; i++) {
            pulse1[i] = (long) Math.pow(-1, i) * sequence[i];
            pulse2[i] = (long) Math.pow(-1, i+1) * sequence[i];
            if (i > 0) {
                pulse1[i] = Math.max(pulse1[i], pulse1[i - 1] + pulse1[i]);
                pulse2[i] = Math.max(pulse2[i], pulse2[i - 1] + pulse2[i]);
            }
        }
        long max1 = Arrays.stream(pulse1).max().getAsLong();
        long max2 = Arrays.stream(pulse2).max().getAsLong();
        answer = Math.max(max1, max2);
        return answer;
    }
}