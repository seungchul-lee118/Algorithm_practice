package bootcamp.example.lv3;

import java.util.Arrays;

public class ConnectIslands {
    public static void main(String[] args) {
        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};

        System.out.println(solution(n, costs));
    }

    // 프로그래머스 lv.3 섬 연결하기

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        int[] islands = new int[n];
        for (int i = 0; i < n; i++) {
            islands[i] = i;
        }
        Arrays.sort(costs, (o1, o2) -> (o1[2] - o2[2]));
        for (int[] cost : costs) {
            int from = Math.min(cost[0], cost[1]);
            int to = Math.max(cost[0], cost[1]);
            int fromRoot = findRoot(from, islands);
            int toRoot = findRoot(to, islands);
            if (fromRoot != toRoot) {
                islands[to] = fromRoot;
                answer += cost[2];
            }
        }
        return answer;
    }

    static int findRoot(int island, int[] islands) {
        if (island == islands[island]) return island;
        islands[island] = findRoot(islands[island], islands);
        return islands[island];
    }

}
