package bootcamp.example;

import java.util.Arrays;

public class TriangleSnail {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(4)));
        System.out.println(Arrays.toString(solution(5)));
        System.out.println(Arrays.toString(solution(6)));
    }

    // 프로그래머스 lv.2 삼각 달팽이

    public static int[] solution(int n) {
        int[][] answer = new int[n][];
        for (int i = 0; i < n; i++) {
            answer[i] = new int[i + 1];
        }
        snail(0, 0, answer, 1, n);
        return Arrays.stream(answer).flatMapToInt(Arrays::stream)
            .toArray();
    }

    public static void snail(int y, int x, int[][] answer, int cnt, int n) {
        for (int i = 0; i < n; i++) {
            answer[y+i][x] = cnt;
            cnt++;
        }
        for (int i = 1; i < n; i++) {
            answer[y+n - 1][x + i] = cnt;
            cnt++;
        }
        for (int i = 1; i < n - 1; i++) {
            answer[y + n - 1 -i][x + n - 1 - i] = cnt;
            cnt++;
        }
        if (n > 3) {
            snail(y+2, x+1, answer, cnt, n-3);
        }
    }
}
