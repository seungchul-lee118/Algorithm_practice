package bootcamp.example.lv2;

import java.util.*;

public class FriendsBlock {
    public static void main(String[] args) {
        int m = 4;
        int n = 5;
        String[] board = {"CCBDE",
            "AAADE",
            "AAABF",
            "CCBBF"};

        System.out.println(solution(m, n, board));
    }

    // 프로그래머스 lv.2 프렌즈4블록

    public static int solution(int m, int n, String[] board) {
        char[][] charBoard = new char[m][n];
        for (int i = 0; i < m; i++) {
            charBoard[i] = board[i].toCharArray();
        }
        return block(charBoard, 0);
    }

    public static int block(char[][] charBoard, int num) {
        int temp = num;
        int m = charBoard.length;
        int n = charBoard[0].length;

        List<int[]> deleteList = new ArrayList<>();
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                char now = charBoard[i][j];
                if (now != '0' && now == charBoard[i][j + 1] &&
                    now == charBoard[i + 1][j] &&
                    now == charBoard[i + 1][j + 1]) {
                    deleteList.add(new int[]{i, j});
                }
            }
        }

        for (int[] arr : deleteList) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    if (charBoard[arr[0] + i][arr[1] + j] != '0') {
                        charBoard[arr[0] + i][arr[1] + j] = '0';
                        num++;
                    }
                }
            }
        }

        ArrayList<Character>[] charList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            charList[i] = new ArrayList<>();
            for (char[] chars : charBoard) {
                if (chars[i] != '0') {
                    charList[i].add(chars[i]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (charList[i].size() != m) {
                int diff = m - charList[i].size();
                for (int j = 0; j < m; j++) {
                    charBoard[j][i] = j < diff ? '0' : charList[i].get(j - diff);
                }
            }
        }

        return temp == num ? num : block(charBoard, num);
    }
}
