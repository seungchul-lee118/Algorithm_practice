package bootcamp.example.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Delivery {
    public static void main(String[] args) {
        int n1 = 5;
        int[][] road1 = {{1, 2, 1}, {2, 3, 3}, {5, 2, 2},
            {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
        int k1 = 3;
        int n2 = 6;
        int[][] road2 = {{1, 2, 1}, {1, 3, 2}, {2, 3, 2},
            {3, 4, 3}, {3, 5, 2}, {3, 5, 3}, {5, 6, 1}};
        int k2 = 4;

        System.out.println(solution(n1, road1, k1));
        System.out.println(solution(n2, road2, k2));
    }

    // 프로그래머스 lv.2 배달 (다익스트라)

    public static int solution(int N, int[][] road, int K) {
        int answer = 0;
        PriorityQueue<Town> queue = new PriorityQueue<>();
        List<Town>[] list = new ArrayList[N + 1];
        int[] dist = new int[N + 1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        Arrays.fill(dist, 5000000);
        dist[1] = 0;
        for (int i = 0; i < road.length; i++) {
            int u = road[i][0];
            int v = road[i][1];
            int w = road[i][2];
            list[u].add(new Town(v, w));
            list[v].add(new Town(u, w));
        }

        queue.add(new Town(1, 0));

        while (!queue.isEmpty()) {
            Town current = queue.poll();
            for (Town next : list[current.number]) {
                if (dist[next.number] > dist[current.number] + next.value) {
                    dist[next.number] = dist[current.number] + next.value;
                    queue.add(new Town(next.number, dist[next.number]));
                }
            }
        }
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        return answer;
    }

    public static class Town implements Comparable<Town>{
        int number;
        int value;

        public Town(int number, int value) {
            this.number = number;
            this.value = value;
        }

        @Override
        public int compareTo(Town o) {
            return this.value - o.value;
        }
    }
}
