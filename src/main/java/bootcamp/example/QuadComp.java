package bootcamp.example;

import java.util.Arrays;

public class QuadComp {
    public static void main(String[] args) {
        int[][] arr1 = {{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        int[][] arr2 =
            {{1, 1, 1, 1, 1, 1, 1, 1},
                {0, 1, 1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 1, 0, 0, 1},
                {0, 0, 0, 0, 1, 1, 1, 1}};

        System.out.println(Arrays.toString(solution(arr1)));
        System.out.println(Arrays.toString(solution(arr2)));
    }

    // 프로그래머스 lv.2 쿼드압축 후 개수 세기
    public static int[] solution(int[][] arr) {
        int[] answer = {0,0};
        compress(0, 0, arr.length, arr, answer);
        return answer;
    }

    public static void compress(int fromRow, int fromCol, int size,
                                int[][] arr, int[] count) {
        int firstNum = arr[fromRow][fromCol];
        if (size == 1) {
            count[firstNum] ++;
            return;
        }
        boolean isSame = true;
        for (int i = fromRow; i < fromRow + size; i++) {
            for (int j = fromCol; j < fromCol + size; j++) {
                if (arr[i][j] != firstNum) {
                    isSame = false;
                }
            }
        }
        if (!isSame) {
            compress(fromRow, fromCol, size / 2, arr, count);
            compress(fromRow, fromCol + size / 2, size / 2, arr, count);
            compress(fromRow + size / 2, fromCol, size / 2, arr, count);
            compress(fromRow + size / 2, fromCol + size / 2, size / 2, arr, count);
        } else {
            count[firstNum] ++;
        }
    }
}
