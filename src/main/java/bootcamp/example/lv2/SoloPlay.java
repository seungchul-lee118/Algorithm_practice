package bootcamp.example.lv2;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SoloPlay {
    public static void main(String[] args) {
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};

        System.out.println(solution(cards));
    }

    // 프로그래머스 lv.2 혼자 놀기의 달인

    public static int solution(int[] cards) {
        int answer = 0;
        boolean[] open = new boolean[cards.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < cards.length; i++) {
            if (open[i]) continue;
            open[i] = true;
            int count = 1;
            int card = cards[i];
            while (!open[card - 1]) {
                open[card - 1] = true;
                card = cards[card - 1];
                count++;
            }
            pq.add(count);
        }
        if (pq.size() <= 1) {
            return 0;
        }
        answer = pq.poll() * pq.poll();
        return answer;
    }
}
