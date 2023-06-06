package bootcamp.example.lv3;

import java.util.Arrays;

public class Entrance {
    public static void main(String[] args) {
        int n1 = 6;
        int[] times1 = {7, 10};
        System.out.println(solution(n1, times1));
    }

    // 프로그래머스 lv.3 입국심사
    public static long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long left = 1;
        long right = (long)times[0] * n;
        long mid;
        long temp;

        while (left <= right) {
            mid = (left + right) / 2;
            temp = 0;
            for (int time : times) {
                temp += (mid / time);
            }
            if (temp >= n) {
                right = mid - 1;
                answer = mid;
            } else {
                left = mid + 1;
            }
        }
        return answer;
    }
}
