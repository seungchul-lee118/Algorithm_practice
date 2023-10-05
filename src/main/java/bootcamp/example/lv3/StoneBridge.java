package bootcamp.example.lv3;

import java.util.ArrayDeque;
import java.util.Deque;

public class StoneBridge {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        System.out.println(solution(stones, k));
    }

    // 프로그래머스 lv.3 징검다리 건너기
    // 길이가 k인 윈도우 내의 최대값을 모았을 때 그 가운데 최솟값

    public static int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < stones.length; i++) {
            // 윈도우 중 가장 큰 값이 deque 앞으로 오도록
            while (!deque.isEmpty() && stones[deque.peekLast()] < stones[i]) {
                deque.pollLast();
            }

            // 윈도우 길이 k (k개의 칸수만 건너 뛸 수 있기 때문에)
            while (!deque.isEmpty() && deque.peekFirst() <= (i - k)) {
                deque.pollFirst();
            }
            deque.addLast(i);
            if (i >= k - 1) answer = Math.min(answer, stones[deque.getFirst()]);
        }
        return answer;
    }
}
