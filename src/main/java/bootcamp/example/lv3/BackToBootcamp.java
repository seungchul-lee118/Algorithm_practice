package bootcamp.example.lv3;

import java.util.*;

public class BackToBootcamp {
    public static void main(String[] args) {
        int n1 = 3;
        int[][] roads1 = {{1, 2}, {2, 3}};
        int[] sources1 = {2, 3};
        int dest1 = 1;

        int n2 = 5;
        int[][] roads2 = {{1, 2}, {1, 4}, {2, 4}, {2, 5}, {4, 5}};
        int[] sources2 = {1, 3, 5};
        int dest2 = 5;

        System.out.println(Arrays.toString(solution(n1, roads1, sources1, dest1)));
        System.out.println(Arrays.toString(solution(n2, roads2, sources2, dest2)));
    }

    // 프로그래머스 Lv.3 부대복귀

    public static int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer>[] arrays = new ArrayList[n + 1];
        int[] dist = new int[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        Arrays.fill(dist, -1);
        dist[destination] = 0;

        for (int i = 0; i < dist.length; i++) {
            arrays[i] = new ArrayList<>();
        }
        for (int i = 0; i < roads.length; i++) {
            arrays[roads[i][0]].add(roads[i][1]);
            arrays[roads[i][1]].add(roads[i][0]);
        }

        queue.add(destination);
        visited[destination] = true;

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (Integer integer : arrays[current]) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    dist[integer] = dist[current] + 1;
                    queue.add(integer);
                }
            }
        }

        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }

        return answer;
    }
}