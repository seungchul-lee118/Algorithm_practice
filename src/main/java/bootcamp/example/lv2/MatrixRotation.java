package bootcamp.example.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MatrixRotation {
    public static void main(String[] args) {
        int rows1 = 6;
        int columns1 = 6;
        int[][] queries1 = {{2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}};
        int rows2 = 3;
        int columns2 = 3;
        int[][] queries2 = {{1, 1, 2, 2}, {1, 2, 2, 3}, {2, 1, 3, 2},
            {2, 2, 3, 3}};
        int rows3 = 100;
        int columns3 = 97;
        int[][] queries3 = {{1, 1, 100, 97}};

        System.out.println(Arrays.toString(solution(rows1, columns1, queries1)));
        System.out.println(Arrays.toString(solution(rows2, columns2, queries2)));
        System.out.println(Arrays.toString(solution(rows3, columns3, queries3)));
    }

    // 프로그래머스 lv.2 행렬 테두리 회전하기

    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] matrix = new int[rows + 1][columns + 1];
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                matrix[i][j] = (i -1) * columns + j;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];
            int min = 10001;
            int temp1 = matrix[x1][y1];
            int temp2 = 0;

            for (int j = y1; j < y2; j++) {
                temp2 = matrix[x1][j + 1];
                matrix[x1][j + 1] = temp1;
                min = Math.min(min, temp1);
                temp1 = temp2;
            }
            for (int j = x1; j < x2; j++) {
                temp2 = matrix[j + 1][y2];
                matrix[j + 1][y2] = temp1;
                min = Math.min(min, temp1);
                temp1 = temp2;
            }
            for (int j = y2; j > y1; j--) {
                temp2 = matrix[x2][j - 1];
                matrix[x2][j - 1] = temp1;
                min = Math.min(min, temp1);
                temp1 = temp2;
            }
            for (int j = x2; j > x1; j--) {
                temp2 = matrix[j - 1][y1];
                matrix[j - 1][y1] = temp1;
                min = Math.min(min, temp1);
                temp1 = temp2;
            }
            answer[i] = min;
        }
        return answer;
    }
}
