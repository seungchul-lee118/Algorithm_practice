package bootcamp.example.lv2;

import java.util.LinkedList;
import java.util.Queue;

public class SameSumQueue {
    public static void main(String[] args) {
        int[] queue11 = {3, 2, 7, 2};
        int[] queue12 = {4, 6, 5, 1};

        int[] queue21 = {1, 2, 1, 2};
        int[] queue22 = {1, 10, 1, 2};

        int[] queue31 = {1, 1};
        int[] queue32 = {1, 5};

        int[] queue41 = {1, 2, 4};
        int[] queue42 = {3, 2, 4};

//        System.out.println(solution(queue11, queue12));
//        System.out.println(solution(queue21, queue22));
//        System.out.println(solution(queue31, queue32));
        System.out.println(solution(queue41, queue42));
    }

    // 프로그래머스 lv.2 두 큐 합 같게 만들기

    public static int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> queueFirst = new LinkedList<>();
        Queue<Integer> queueSecond = new LinkedList<>();

        for (int i = 0; i < queue1.length; i++) {
            queueFirst.add(queue1[i]);
            queueSecond.add(queue2[i]);
        }
        long sum1 = queueFirst.stream().mapToLong(n -> n).sum();
        long sum2 = queueSecond.stream().mapToLong(n -> n).sum();
        long totalSum = sum1 + sum2;
        if (totalSum % 2 == 1) return -1;

        while (sum1 != sum2) {
            Integer headFirst = queueFirst.peek();
            Integer headSecond = queueSecond.peek();
            if (answer > queue1.length*4) {
                return -1;
            }
            if (sum1 > sum2) {
                queueSecond.add(queueFirst.poll());
                sum1 -= headFirst;
                sum2 += headFirst;
            } else {
                queueFirst.add(queueSecond.poll());
                sum1 += headSecond;
                sum2 -= headSecond;
            }
            answer++;
        }
        return answer;
    }
}
