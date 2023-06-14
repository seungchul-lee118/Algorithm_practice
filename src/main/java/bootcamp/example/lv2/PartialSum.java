package bootcamp.example.lv2;

import java.util.Arrays;

public class PartialSum {
    public static void main(String[] args) {
        int[] sequence1 = {1, 2, 3, 4, 5};
        int[] sequence2 = {1, 1, 1, 2, 3, 4, 5};
        int[] sequence3 = {2, 2, 2, 2, 2};

        System.out.println(Arrays.toString(solution(sequence1, 7)));
        System.out.println(Arrays.toString(solution(sequence2, 5)));
        System.out.println(Arrays.toString(solution(sequence3, 6)));
    }

    // 프로그래머스 lv.2 연속된 부분 수열의 합

    public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        int rightIdx = 0;
        int leftIdx = 0;
        long sum = 0;
        int width = 1000001;

        while (rightIdx < sequence.length) {
            sum += sequence[rightIdx];
            rightIdx++;
            if (sum > k) {
                while (sum > k) {
                    sum -= sequence[leftIdx];
                    leftIdx++;
                }
            }
            if (sum == k) {
                if (rightIdx - leftIdx < width) {
                    width = Math.min(width, rightIdx - leftIdx);
                    answer = new int[]{leftIdx, rightIdx - 1};
                }
            }
        }

        return answer;
    }
}
