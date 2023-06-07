package bootcamp.example.lv3;

import java.util.*;

public class Ranking {
    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(solution(n, results));
    }

    // 프로그래머스 Lv.3 순위 (플로이드-워셜)

    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] array = new int[n + 1][n + 1];
        for (int[] result : results) {
            array[result[0]][result[1]] = 1;
            array[result[1]][result[0]] = - 1;
        }
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (array[i][k] == 1 && array[k][j] == 1) {
                        array[i][j] = 1;
                        array[j][i] = -1;
                    }
                }
            }
        }
        for (int i = 1; i <= n; i++) {
            if (Arrays.stream(array[i]).filter(num -> num != 0).count() == n-1) {
                answer++;
            }
        }
        return answer;
    }
}