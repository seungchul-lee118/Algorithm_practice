package bootcamp.example.lv3;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Network {
    public static void main(String[] args) {
        int n1 = 3;
        int[][] computers1 = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        int n2 = 3;
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        System.out.println(solution(n1, computers1));
        System.out.println(solution(n2, computers2));
    }

    // 프로그래머스 lv.3 네트워크
    public static int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;
            queue.add(i);
            visited[i] = true;
            answer++;
            while (!queue.isEmpty()) {
                Integer now = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (visited[j] || computers[now][j] == 0) continue;
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }

        return answer;
    }

    //다른 사람 풀이
    public static int solution1(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                dfs(computers, visited, i);
                answer++;
            }
        }
        return answer;
    }
    static void dfs(int[][] computers, boolean[] visited, int start) {
        visited[start] = true;
        for(int i = 0; i < computers.length; i++) {
            if(computers[start][i] == 1 && !visited[i]) {
                dfs(computers, visited, i);
            }
        }
    }
}
