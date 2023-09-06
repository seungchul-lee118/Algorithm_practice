package bootcamp.example.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class Ricochat {
    public static void main(String[] args) {
        String[] board1 = {
            "...D..R",
            ".D.G...",
            "....D.D",
            "D....D.",
            "..D...."};
        String[] board2 = {
            ".D.R",
            "....",
            ".G..",
            "...D"};

        System.out.println(solution(board1));
//        System.out.println(solution(board2));
    }

    // 프로그래머스 lv.2 리코쳇 로봇

    public static int solution(String[] board) {
        int answer = 10000;
        int height = board.length;
        int width = board[0].length();
        boolean[][] visited = new boolean[height][width];

        // 동, 서, 남, 북
        int[] rows = {0, 0, 1, -1};
        int[] cols = {1, -1,0, 0};

        int[] start = findStartPosition(board);
        visited[start[0]][start[1]] = true;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(start[0], start[1], 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int row = current.row;
            int col = current.col;

            if (answer < current.count) continue;

            if (board[row].charAt(col) == 'G') {
                answer = Math.min(answer, current.count);
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = row + rows[i];
                int nextCol = col + cols[i];

                if (nextRow < 0 || nextRow >= height || nextCol < 0 || nextCol >= width) continue;

                if (board[nextRow].charAt(nextCol) == 'D') continue;

                while (nextRow >= 0 && nextRow < height && nextCol >= 0 && nextCol < width
                    && board[nextRow].charAt(nextCol) != 'D') {
                    nextRow += rows[i];
                    nextCol += cols[i];
                }
                nextRow -= rows[i];
                nextCol -= cols[i];

                if (visited[nextRow][nextCol]) {
                    continue;
                }
                visited[nextRow][nextCol] = true;

                queue.offer(new Node(nextRow, nextCol, current.count+1));
            }
        }

        return answer == 10000 ? -1 : answer;
    }

    public static int[] findStartPosition(String[] board) {
        int[] start = new int[2];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        return start;
    }

    public static class Node {
        int row;
        int col;
        int count;
        public Node(int row, int col, int count) {
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }

}
