package bootcamp.example.lv3;

import java.util.*;

public class BuildTrack {
    public static void main(String[] args) {
        int[][] board1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int[][] board2 = {{0,0,0,0,0,0,0,1}, {0,0,0,0,0,0,0,0},
            {0,0,0,0,0,1,0,0}, {0,0,0,0,1,0,0,0}, {0,0,0,1,0,0,0,1},
            {0,0,1,0,0,0,1,0}, {0,1,0,0,0,1,0,0}, {1,0,0,0,0,0,0,0}};
        int[][] board3 = {{0,0,1,0}, {0,0,0,0}, {0,1,0,1}, {1,0,0,0}};
        int[][] board4 = {{0,0,0,0,0,0}, {0,1,1,1,1,0}, {0,0,1,0,0,0},
            {1,0,0,1,0,1}, {0,1,0,0,0,1}, {0,0,0,0,0,0}};
        System.out.println(solution(board1));
        System.out.println(solution(board2));
        System.out.println(solution(board3));
        System.out.println(solution(board4));
    }

    // 프로그래머스 lv.3 경주로 건설
    public static int solution(int[][] board) {
        int n = board.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == 1 ? 1 : 100000;
            }
        }

        Map<Integer, int[]> direction = new HashMap<>();
        direction.put(1, new int[]{-1, 0});
        direction.put(2, new int[]{0, 1});
        direction.put(3, new int[]{1, 0});
        direction.put(4, new int[]{0, -1});

        dfs(board, 0, 0, 0, 0, direction);

        return board[n-1][n-1];
    }

    public static void dfs(int[][] board, int dir, int pay, int y, int x, Map<Integer, int[]> direction) {
        if (!inBoard(board.length, y, x) || board[y][x] == 1 || board[y][x] + 600 < pay) {
            return ;
        }

        board[y][x] = Math.min(board[y][x], pay);
        for (int i = 1; i <= 4; i++) {
            int nextY = y + direction.get(i)[0];
            int nextX = x + direction.get(i)[1];

            if (dir == i || dir == 0) {
                dfs(board, i, pay + 100, nextY, nextX, direction);
            } else {
                dfs(board, i, pay + 600, nextY, nextX, direction);
            }
        }
    }

    public static boolean inBoard(int boardLength, int y, int x) {
        return (y >= 0) && (y < boardLength) && (x >= 0) && (x < boardLength);
    }

}
