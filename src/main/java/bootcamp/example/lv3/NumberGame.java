package bootcamp.example.lv3;

import java.util.PriorityQueue;

public class NumberGame {
    public static void main(String[] args) {
        int[] A1 = {5, 1, 3, 7};
        int[] B1 = {2, 2, 6, 8};

        int[] A2 = {2, 2, 2, 2};
        int[] B2 = {1, 1, 1, 1};

        System.out.println(solution(A1, B1));
        System.out.println(solution(A2, B2));
    }

    // 프로그래머스 Lv.3 숫자게임

    public static int solution(int[] A, int[] B) {
        int answer = 0;
        PriorityQueue<Integer> pqA = new PriorityQueue<>();
        PriorityQueue<Integer> pqB = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            pqA.offer(A[i]);
            pqB.offer(B[i]);
        }

        while (!pqA.isEmpty() && !pqB.isEmpty()) {
            Integer nowB = pqB.poll();
            if (nowB > pqA.peek()) {
                pqA.poll();
                answer++;
            }
        }
        return answer;
    }
}