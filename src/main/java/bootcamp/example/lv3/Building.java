package bootcamp.example.lv3;


public class Building {
    public static void main(String[] args) {
        int[][] board1 = {
            {5, 5, 5, 5, 5},
            {5, 5, 5, 5, 5},
            {5, 5, 5, 5, 5},
            {5, 5, 5, 5, 5}};
        int[][] skill1 = {
            {1, 0, 0, 3, 4, 4},
            {1, 2, 0, 2, 3, 2},
            {2, 1, 0, 3, 1, 2},
            {1, 0, 1, 3, 3, 1}};

        int[][] board2 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}};
        int[][] skill2 = {
            {1,1,1,2,2,4},
            {1,0,0,1,1,2},
            {2,2,0,2,0,100}};

        System.out.println(solution(board1, skill1));
        System.out.println(solution(board2, skill2));
    }

    // 프로그래머스 Lv.3 파괴되지 않은 건물 (2차원 구간합)

    public static int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int[][] sumArray = new int[board.length + 1][board[0].length + 1];
        for (int[] ints : skill) {
            if (ints[0] == 1) {
                sumArray[ints[1]][ints[2]] -= ints[5];
                sumArray[ints[3] + 1][ints[2]] += ints[5];
                sumArray[ints[1]][ints[4] + 1] += ints[5];
                sumArray[ints[3] + 1][ints[4] + 1] -= ints[5];
            } else {
                sumArray[ints[1]][ints[2]] += ints[5];
                sumArray[ints[3] + 1][ints[2]] -= ints[5];
                sumArray[ints[1]][ints[4] + 1] -= ints[5];
                sumArray[ints[3] + 1][ints[4] + 1] += ints[5];
            }
        }
        for (int i = 0; i < sumArray.length; i++) {
            for (int j = 1; j < sumArray[0].length; j++) {
                sumArray[i][j] += sumArray[i][j - 1];
            }
        }

        for (int j = 0; j < sumArray[0].length; j++) {
            for (int i = 1; i < sumArray.length; i++) {
                sumArray[i][j] += sumArray[i - 1][j];
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] += sumArray[i][j];
                if (board[i][j] > 0) {
                    answer++;
                }
            }
        }
        return answer;
    }
}