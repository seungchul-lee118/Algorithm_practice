package bootcamp.example.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collatz {
    public static void main(String[] args) {
        int k1 = 5;
        int[][] ranges1 = {{0, 0}, {0, -1}, {2, -3}, {3, -3}};

        int k2 = 3;
        int[][] ranges2 = {{0, 0}, {1, -2}, {3, -3}};

        System.out.println(Arrays.toString(solution(k1, ranges1)));
        System.out.println(Arrays.toString(solution(k2, ranges2)));
    }

    // 프로그래머스 lv.2 우박수열 정적분

    public static double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        List<Integer> list = new ArrayList<>();
        while (k > 1) {
            list.add(k);
            if (k % 2 == 0) {
                k /= 2;
            } else {
                k = k * 3 + 1;
            }
        }
        list.add(k);

        int n = list.size() - 1;

        for (int i = 0; i < ranges.length; i++) {
            int rangeStart = ranges[i][0];
            int rangeEnd = n + ranges[i][1];

            if (rangeStart > rangeEnd) {
                answer[i] = -1.0;
                continue;
            }
            for (int j = rangeStart; j < rangeEnd; j++) {
                answer[i] += (list.get(j) + list.get(j + 1)) / 2.0;
            }
        }

        return answer;
    }
}