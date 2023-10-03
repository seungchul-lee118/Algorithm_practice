package bootcamp.example.lv3;

import java.util.Arrays;

public class BestGroup {
    public static void main(String[] args) {
        int n1 = 2;
        int s1 = 9;

        int n2 = 2;
        int s2 = 1;

        int n3 = 2;
        int s3 = 8;

        System.out.println(Arrays.toString(solution(n1, s1)));
        System.out.println(Arrays.toString(solution(n2, s2)));
        System.out.println(Arrays.toString(solution(n3, s3)));
    }

    // 프로그래머스 lv.3 최고의 집합
    public static int[] solution(int n, int s) {
        int[] answer = new int[n];
        int total = s;
        if (s < n) return new int[]{-1};

        for (int i = 0; i < n; i++) {
            answer[i] = s / n;
            total -= s / n;
        }
        while (total > 0) {
            answer[--n]++;
            total--;
        }

        return answer;
    }
}
