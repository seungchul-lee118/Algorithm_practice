package bootcamp.example.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class HalfWires {
    public static void main(String[] args) {
        int n1 = 9;
        int[][] wires1 = {{1, 3}, {2, 3}, {3, 4}, {4, 5},
            {4, 6}, {4, 7}, {7, 8}, {7, 9}};
        int n2 = 4;
        int[][] wires2 = {{1, 2}, {2, 3}, {3, 4}};
        int n3 = 7;
        int[][] wires3 = {{1, 2}, {2, 7}, {3, 7},
            {3, 4}, {4, 5}, {6, 7}};

        System.out.println(solution(n1, wires1));
        System.out.println(solution(n2, wires2));
        System.out.println(solution(n3, wires3));
    }

    // 프로그래머스 lv.2 전력망을 둘로 나누기

    public static int solution(int n, int[][] wires) {
        int answer = 100;
        ArrayList[] list = new ArrayList[n + 1];
        boolean[] cut = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<Integer>();
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            list[v1].add(v2);
            list[v2].add(v1);
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            cut[v1] = true;
            cut[v2] = true;
            int network1 = bfs(v1, list, cut);
            int network2 = bfs(v2, list, cut);
            answer = Math.min(answer, Math.abs(network1 - network2));
            cut[v1] = false;
            cut[v2] = false;
        }

        return answer;
    }

    public static int bfs(int start, ArrayList<Integer>[] list, boolean[] cut) {
        int count = 0;
        boolean[] visited = Arrays.copyOf(cut, cut.length);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            count ++;
            for (Integer next : list[node]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        return count;
    }
}
