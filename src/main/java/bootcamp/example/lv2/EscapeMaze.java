package bootcamp.example.lv2;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class EscapeMaze {
    public static void main(String[] args) {
        String[] maps1 = {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"};
        String[] maps2 = {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"};

        System.out.println(solution(maps1));
        System.out.println(solution(maps2));
    }

    // 프로그래머스 lv.2 미로 탈출

    public static int solution(String[] maps) {
        int answer = 0;
        int height = maps.length;
        int width = maps[0].length();
        String[][] splitMap = new String[height][width];
        int[][] spots = new int[3][2];
        for (int i = 0; i < height; i++) {
            splitMap[i] = maps[i].split("");
        }
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (splitMap[i][j].equals("S")) {
                    spots[0][0] = i;
                    spots[0][1] = j;
                } else if (splitMap[i][j].equals("L")) {
                    spots[1][0] = i;
                    spots[1][1] = j;
                } else if (splitMap[i][j].equals("E")) {
                    spots[2][0] = i;
                    spots[2][1] = j;
                }
            }
        }
        int[] startSpot = spots[0];
        int[] leverSpot = spots[1];
        int[] exitSpot = spots[2];

        answer = findTimeToSpot(startSpot, leverSpot, splitMap) + findTimeToSpot(leverSpot, exitSpot, splitMap);
        if (answer > 1000) {
            return -1;
        }
        return answer;
    }

    public static int findTimeToSpot(int[] startSpot, int[] targetSpot, String[][] splitMap) {
        int height = splitMap.length;
        int width = splitMap[0].length;
        int[][] times = new int[height][width];
        for (int i = 0; i < height; i++) {
            Arrays.fill(times[i], 1000);
        }
        times[startSpot[0]][startSpot[1]] = 0;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[height][width];

        queue.add(startSpot);
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int row = now[0];
            int col = now[1];
            if (visited[now[0]][now[1]]) {
                continue;
            }
            visited[now[0]][now[1]] = true;

            nextPosition(row, col, row - 1, col, times, visited, splitMap, queue);
            nextPosition(row, col, row + 1, col, times, visited, splitMap, queue);
            nextPosition(row, col, row, col - 1, times, visited, splitMap, queue);
            nextPosition(row, col, row, col + 1, times, visited, splitMap, queue);
        }

        return times[targetSpot[0]][targetSpot[1]];
    }

    static void nextPosition(int nowRow, int nowCol, int nextRow, int nextCol, int[][] times, boolean[][] visited, String[][] splitMap, Queue<int[]> queue) {
        if (isInMap(nextRow , nextCol, splitMap) && !visited[nextRow][nextCol] && !splitMap[nextRow][nextCol].equals("X")) {
            queue.add(new int[]{nextRow, nextCol});
            times[nextRow][nextCol] = Math.min(times[nextRow][nextCol], times[nowRow][nowCol] + 1);
        }
    }

    public static boolean isIsolate(int row, int col, String[][] splitMap) {
        if (isInMap(row - 1, col, splitMap) && !splitMap[row-1][col].equals("X")) {
            return false;
        }
        if (isInMap(row + 1, col, splitMap) && !splitMap[row+1][col].equals("X")) {
            return false;
        }
        if (isInMap(row, col - 1, splitMap) && !splitMap[row][col-1].equals("X")) {
            return false;
        }
        if (isInMap(row, col + 1, splitMap) && !splitMap[row][col+1].equals("X")) {
            return false;
        }
        return true;
    }

    public static boolean isInMap(int row, int col, String[][] splitMap) {
        int height = splitMap.length;
        int width = splitMap[0].length;
        if (row >= 0 && row < height && col >= 0 && col < width) {
            return true;
        }
        return false;
    }
}
