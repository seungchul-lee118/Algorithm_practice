package bootcamp.example.lv3;

import java.util.LinkedList;
import java.util.Queue;

public class GoingSchool {
    public static void main(String[] args) {
        int m = 4;
        int n = 3;
        int[][] puddles = {{2, 2}};

        System.out.println(solution(m, n, puddles));
    }

    // 프로그래머스 Lv.3 등굣길

    public static int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        map[0][0] = 1;
        queue.add(new int[]{0, 0});

        for (int[] puddle : puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;
        }

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            visited[now[1]][now[0]] = true;
            if ((now[0]+1 < m) && map[now[1]][now[0]+1] != -1) {
                map[now[1]][now[0]+1] = (map[now[1]][now[0]+1]+map[now[1]][now[0]])%1000000007;
                if (!visited[now[1]][now[0]+1]){
                    queue.add(new int[]{now[0]+1, now[1]});
                    visited[now[1]][now[0]+1] = true;
                }
            }
            if ((now[1]+1 < n) && map[now[1]+1][now[0]] != -1) {
                map[now[1]+1][now[0]] = (map[now[1]+1][now[0]]+map[now[1]][now[0]])%1000000007;
                if (!visited[now[1]+1][now[0]]){
                    queue.add(new int[]{now[0], now[1]+1});
                    visited[now[1]+1][now[0]] = true;
                }
            }
        }

        answer = map[n-1][m-1]%1000000007;

        return answer;
    }
}