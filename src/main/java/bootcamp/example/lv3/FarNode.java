package bootcamp.example.lv3;

import java.util.*;

public class FarNode {
    public static void main(String[] args) {
        int n = 6;
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4},{5, 2}};

        System.out.println(solution(n, vertex));
    }

    // 프로그래머스 lv.3 가장 먼 노드

    public static int solution(int n, int[][] edge) {
        int answer = 0;
        int depth = 0;
        ArrayList<Integer>[] lists = new ArrayList[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        Node[] nodes = new Node[n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
            nodes[i] = new Node(i, 0);
        }

        for (int i = 0; i < edge.length; i++) {
            int from = edge[i][0];
            int to = edge[i][1];
            lists[from].add(to);
            lists[to].add(from);
        }

        queue.add(1);
        visited[1] = true;

        while (!queue.isEmpty()) {
            Integer node = queue.poll();
            depth = nodes[node].depth;

            for (Integer nextNode : lists[node]) {
                if (visited[nextNode]) continue;
                visited[nextNode] = true;
                queue.add(nextNode);
                nodes[nextNode].depth = depth + 1;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (nodes[i].depth == depth) answer++;
        }

        return answer;
    }

    static class Node {
        int idx;
        int depth;

        public Node(int idx, int depth) {
            this.idx = idx;
            this.depth = depth;
        }
    }
}
