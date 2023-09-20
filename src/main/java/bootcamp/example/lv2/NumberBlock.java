package bootcamp.example.lv2;

import java.util.*;

public class NumberBlock {
    public static void main(String[] args) {
        long begin = 1;
        long end = 10;

        System.out.println(Arrays.toString(solution(begin, end)));
    }

    // 프로그래머스 lv.2 숫자 블록

    public static int[] solution(long begin, long end) {
        int range = (int) (end - begin);
        int[] answer = new int[range + 1];

        for (int i = 0; i < range + 1; i++) {
            long num = i + begin;
            answer[i] = getMaxDivisor(num);
        }

        return answer;
    }

    static int getMaxDivisor(long num) {
        if (num == 1) return 0;
        List<Integer> list = new ArrayList<>();

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                list.add(i);
                if (num / i <= 10_000_000) {
                    return (int) (num / i);
                }
            }
        }
        if (!list.isEmpty()) {
            return list.get(list.size() - 1);
        }

        return 1;
    }
}