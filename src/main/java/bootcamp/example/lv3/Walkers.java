package bootcamp.example.lv3;

import java.util.*;

public class Walkers {
    public static void main(String[] args) {
        int m1 = 3;
        int n1 = 3;
        int[][] cityMap1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        int m2 = 3;
        int n2 = 6;
        int[][] cityMap2 = {{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};

        System.out.println(solution(m1, n1, cityMap1));
        System.out.println(solution(m2, n2, cityMap2));
    }

    // 프로그래머스 Lv.3 보행자 천국

    static int MOD = 20170805;
    public static int solution(int m, int n, int[][] cityMap) {
        int[][][] dist = new int[m][n][2];

        dist[0][0][0] = 1;
        dist[0][0][1] = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) continue;
                if (j > 0) {
                    if (cityMap[i][j - 1] == 0) {
                        dist[i][j][0] += (dist[i][j - 1][0] + dist[i][j - 1][1]) % MOD;
                    } else if (cityMap[i][j - 1] == 1) {
                        dist[i][j][0] = 0;
                    } else {
                        dist[i][j][0] = dist[i][j - 1][0];
                    }
                }

                if (i > 0) {
                    if (cityMap[i - 1][j] == 0) {
                        dist[i][j][1] += (dist[i - 1][j][0] + dist[i - 1][j][1]) % MOD;
                    } else if (cityMap[i - 1][j] == 1) {
                        dist[i][j][1] = 0;
                    } else {
                        dist[i][j][1] = dist[i - 1][j][1];
                    }
                }
            }
        }

        return (dist[m - 1][n - 1][0] + dist[m - 1][ n - 1][1]) % MOD;
    }
}