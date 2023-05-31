package bootcamp.example;

import java.util.ArrayDeque;
import java.util.Deque;

public class StoneBridge {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        System.out.println(solution(stones, k));
    }

    // 프로그래머스 lv.3 징검다리 건너기

    public static int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < stones.length; i++) {
            while (!deque.isEmpty() && stones[deque.peekLast()] < stones[i]) {
                deque.pollLast();
            }
            while (!deque.isEmpty() && deque.peekFirst() <= (i - k)) {
                deque.pollFirst();
            }
            deque.addLast(i);
            if (i >= k - 1) answer = Math.min(answer, stones[deque.getFirst()]);
        }
        return answer;
    }
}
