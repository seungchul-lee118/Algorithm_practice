package bootcamp.example.lv3;

import java.util.Arrays;

public class PillarBeam {
    public static void main(String[] args) {
        int n1 = 5;
        int[][] build_frame1 = {
            {1, 0, 0, 1}, {1, 1, 1, 1}, {2, 1, 0, 1}, {2, 2, 1, 1},
            {5, 0, 0, 1}, {5, 1, 0, 1}, {4, 2, 1, 1}, {3, 2, 1, 1}};

        int n2 = 5;
        int[][] build_frame2 = {
            {0, 0, 0, 1}, {2, 0, 0, 1}, {4, 0, 0, 1}, {0, 1, 1, 1},
            {1, 1, 1, 1}, {2, 1, 1, 1}, {3, 1, 1, 1}, {2, 0, 0, 0},
            {1, 1, 1, 0}, {2, 2, 0, 1}};

        for (int[] ints : solution(n1, build_frame1)) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        for (int[] ints : solution(n2, build_frame2)) {
            System.out.println(Arrays.toString(ints));
        }

    }

    // 프로그래머스 lv.3 기둥과 보 설치
    // build_frame : [x, y, a, b]
    // a - 0: 기둥, 1: 보
    // b - 0: 삭제, 1: 설치
    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer;
        int[][][] map = new int[n + 1][n + 1][2];
        int count = 0;
        for (int i = 0; i < build_frame.length; i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int a = build_frame[i][2];
            int b = build_frame[i][3];

            if (b == 1) {
                if (installable(x, y, a, map)) {
                    map[x][y][a] = 1;
                    count++;
                }
            } else {
                if (deletable(x, y, a, map)) {
                    count--;
                } else {
                    map[x][y][a] = 1;
                }
            }
        }

        answer = new int[count][3];
        int idx = 0;

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < n + 1; j++) {
                for (int k = 0; k < 2; k++) {
                    if (map[i][j][k] == 1) {
                        answer[idx][0] = i;
                        answer[idx][1] = j;
                        answer[idx++][2] = k;
                    }
                }
            }
        }
        return answer;
    }

    static boolean installable(int x, int y, int a, int[][][] map) {
        if (a == 0) {
            if (y == 0) {
                return true;
            }
            if (x - 1 >= 0 && map[x-1][y][1] == 1) return true;
            if (map[x][y][1] == 1) return true;
            if (map[x][y-1][0] == 1) return true;
        } else {
            if (map[x][y-1][0] == 1) return true;
            if (map[x + 1][y-1][0] == 1) return true;
            if (x - 1 >= 0 && map[x-1][y][1] == 1 && map[x+1][y][1] == 1) return true;
        }
        return false;
    }

    static boolean deletable(int x, int y, int a, int[][][] map) {
        int n = map.length - 1;
        map[x][y][a] = 0;
        if (a == 0) {
            if (y <= n - 2 && map[x][y + 1][0] == 1 && !installable(x, y+1, 0, map)) return false;
            if (x + 1 <= n && map[x][y + 1][1] == 1 && !installable(x, y + 1, 1, map)) return false;
            if (x - 1 >= 0 && map[x - 1][y + 1][1] == 1 && !installable(x - 1, y + 1, 1, map)) return false;
        } else {
            if (y <= n - 1 && map[x][y][0] == 1 && !installable(x, y, 0, map)) return false;
            if (y <= n - 1 && map[x + 1][y][0] == 1 && !installable(x + 1, y, 0, map)) return false;
            if (x + 2 <= n && map[x+1][y][1] == 1 && !installable(x + 1, y, 1, map)) return false;
            if (x - 1 >= 0 && map[x-1][y][1] == 1 && !installable(x - 1, y, 1, map)) return false;
        }
        return true;
    }
}
