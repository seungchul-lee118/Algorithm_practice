package bootcamp.example.lv3;

import java.util.LinkedList;
import java.util.Queue;

public class GoingSchool {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        System.out.println(solution(m, n, puddles));
    }

    // 프로그래머스 Lv.3 등굣길

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[n][m];
        map[0][0] = 1;

        for (int[] puddle : puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0;
                    continue;
                }
                if (i != 0) map[i][j] += map[i - 1][j] % 1000000007;
                if (j != 0) map[i][j] += map[i][j - 1] % 1000000007;
            }
        }

        answer = map[n-1][m-1]%1000000007;

        return answer;
    }
}