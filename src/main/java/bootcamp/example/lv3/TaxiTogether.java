package bootcamp.example.lv3;

import org.w3c.dom.Node;

import java.util.*;

public class TaxiTogether {
    public static void main(String[] args) {
        int n1 = 6;
        int s1 = 4;
        int a1 = 6;
        int b1 = 2;
        int[][] fares1 = {{4,1,10}, {3,5,24}, {5,6,2}, {3,1,41}, {5,1,24},
            {4,6,50}, {2,4,66}, {2,3,22}, {1,6,25}};
        int n2 = 7;
        int s2 = 3;
        int a2 = 4;
        int b2 = 1;
        int[][] fares2 = {{5,7,9}, {4,6,4}, {3,6,1}, {3,2,3}, {2,1,6}};
        int n3 = 6;
        int s3 = 4;
        int a3 = 5;
        int b3 = 6;
        int[][] fares3 = {{2,6,6}, {6,3,7}, {4,6,7}, {6,5,11}, {2,5,12},
            {5,3,20}, {2,4,8}, {4,3,9}};
        System.out.println(solution(n1, s1, a1, b1, fares1));
//        System.out.println(solution(n2, s2, a2, b2, fares2));
//        System.out.println(solution(n3, s3, a3, b3, fares3));
    }

    // 프로그래머스 lv.3 합승 택시 요금
    public static int solution(int n, int s, int a, int b, int[][] fares) {
        ArrayList<Edge>[] list = new ArrayList[n + 1];
        boolean[][] visited = new boolean[3][n + 1];
        int[][] distance = new int[4][n + 1];
        PriorityQueue<Edge>[] queues = new PriorityQueue[3];
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }

        //택시 요금 배열 초기화, 다익스트라 알고리즘 우선순위 큐 초기화
        for (int i = 0; i < 3; i++) {
            Arrays.fill(distance[i], 100001);
            queues[i] = new PriorityQueue<>();
        }

        //인접 리스트
        for (int[] fare : fares) {
            list[fare[0]].add(new Edge(fare[1], fare[2]));
            list[fare[1]].add(new Edge(fare[0], fare[2]));
        }

        //다익스트라 초기점 요금 0으로 설정
        distance[0][s] = 0;
        distance[1][a] = 0;
        distance[2][b] = 0;

        queues[0].add(new Edge(s, 0));
        queues[1].add(new Edge(a, 0));
        queues[2].add(new Edge(b, 0));

        //각 출발지마다 모든 지점에 대한 최소 금액 구하기
        for (int i = 0; i < 3; i++) {
            while (!queues[i].isEmpty()) {
                Edge current = queues[i].poll();
                int currentNode = current.end;
                if (visited[i][currentNode]) continue;
                visited[i][currentNode] = true;
                for (Edge edge : list[currentNode]) {
                    int nextNode = edge.end;
                    int value = edge.value;
                    if (distance[i][nextNode] > distance[i][currentNode] + value) {
                        distance[i][nextNode] = distance[i][currentNode] + value;
                        queues[i].add(new Edge(nextNode, distance[i][nextNode]));
                    }
                }
            }
            System.out.println(Arrays.toString(distance[i]));
        }
        for (int i = 0; i < n+1; i++) {
            distance[3][i] = distance[0][i] + distance[1][i] + distance[2][i];
        }
        System.out.println(Arrays.toString(distance[3]));

        return Arrays.stream(distance[3]).min().getAsInt();
    }

    public static class Edge implements Comparable<Edge>{
        private int end;
        private int value;

        public Edge(int end, int value) {
            this.end = end;
            this.value = value;
        }

        @Override
        public int compareTo(Edge o) {
            return value - o.value;
        }
    }
}
