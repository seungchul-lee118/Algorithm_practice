package bootcamp.example.lv3;

import java.util.*;

public class KeyLock {
    public static void main(String[] args) {
        int[][] key = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int[][] lock = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(key, lock));
    }

    // 프로그래머스 lv.3 자물쇠와 열쇠
    public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        int[][] rotated90 = rotateClockwise90(key);
        int[][] rotated180 = rotateClockwise90(rotated90);
        int[][] rotated270 = rotateClockwise90(rotated180);

        for (int i = 1 - key.length; i < lock.length; i++) {
            for (int j = 1- key.length; j < lock.length; j++) {
                answer = answer || match(i, j, key, lock);
                answer = answer || match(i, j, rotated90, lock);
                answer = answer || match(i, j, rotated180, lock);
                answer = answer || match(i, j, rotated270, lock);
            }
        }

        return answer;
    }

    public static int[][] rotateClockwise90(int[][] key) {
        int m = key.length;
        int[][] rotatedKey = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                rotatedKey[j][m - 1 - i] = key[i][j];
            }
        }
        return rotatedKey;
    }

    public static boolean match(int right, int down, int[][] key, int[][] lock) {
        int n = lock.length;
        int m = key.length;
        int count = 0;
        for (int[] ints : lock) {
            count += Arrays.stream(ints).filter(num -> num == 0).count();
        }
        for (int i = 0; i < m; i++) {
            if (i + down >= n || i + down < 0) {
                continue;
            }
            for (int j = 0; j < m; j++) {
                if (j + right >= n || j + right < 0) {
                    continue;
                }
                if (key[i][j] == lock[i+down][j+right]) {
                    return false;
                }
                if (key[i][j] == 1 && lock[i+down][j+right] == 0) {
                    count --;
                }
            }
        }
        return count == 0;
    }
}
