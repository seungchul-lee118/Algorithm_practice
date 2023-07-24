package bootcamp.example.lv2;

public class LargestSquare {
    public static void main(String[] args) {
        int[][] board1 = {{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}};
        int[][] board2 = {{0,0,1,1}, {1,1,1,1}};

        System.out.println(solution(board1));
        System.out.println(solution(board2));
    }

    // 프로그래머스 lv.2 가장 큰 정사각형 찾기

    public static int solution(int[][] board) {
        int maxLength = 0;
        int row = board.length;
        int col = board[0].length;
        int[][] dp = new int[row][col];
        for (int i = 0; i < row; i++) {
            dp[i][0] = board[i][0];
        }
        for (int j = 0; j < col; j++) {
            dp[0][j] = board[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (board[i][j] == 1) {
                    int min = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                    dp[i][j] = min + 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength * maxLength;
    }
}
