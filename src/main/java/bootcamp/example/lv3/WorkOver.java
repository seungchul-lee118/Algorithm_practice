package bootcamp.example.lv3;

import java.util.Comparator;
import java.util.PriorityQueue;

public class WorkOver {
    public static void main(String[] args) {
        int n1 = 4;
        int[] works1 = {4, 3, 3};

        int n2 = 1;
        int[] works2 = {2, 1, 2};

        int n3 = 3;
        int[] works3 = {1, 1};

        System.out.println(solution(n1, works1));
        System.out.println(solution(n2, works2));
        System.out.println(solution(n3, works3));
    }

    // 프로그래머스 lv.3 야근 지수
    public static long solution(int n, int[] works) {
        long answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        int sum = 0;
        for (int work : works) {
            pq.offer(work);
            sum += work;
        }
        if (n >= sum) return 0;
        while (n > 0) {
            Integer largest = pq.poll();
            largest--;
            n--;
            pq.offer(largest);
        }
        for (Integer integer : pq) {
            answer += integer * integer;
        }

        return answer;
    }
}
