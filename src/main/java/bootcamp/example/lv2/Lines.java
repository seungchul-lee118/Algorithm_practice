package bootcamp.example.lv2;

import java.util.*;

public class Lines {
    public static void main(String[] args) {
        int n1 = 3;
        int k1 = 5;

        System.out.println(Arrays.toString(solution(n1, k1)));
    }

    // 프로그래머스 lv.2 줄 서는 방법

    public static int[] solution(int n, long k) {
        int[] answer = new int[n];
        long[] factorial = new long[n + 1];
        List<Integer> resultList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 1; i < n + 1; i++) {
            long result = 1;
            list.add(i);
            for (int j = 1; j < i + 1; j++) {
                result *= j;
            }
            factorial[i] = result;
        }

        for (int i = 0; i < n - 1; i++) {
            int index = (int) (k / factorial[n - 1 - i]);
            k = k % factorial[n - 1 - i];
            if (k == 0) {
                resultList.add(list.remove(index - 1));
                break;
            }
            resultList.add(list.remove(index));
        }
        for (int i = 0; i < list.size(); i++) {
            resultList.add(list.get(list.size() - 1 - i));
        }

        for (int i = 0; i < n; i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }
}
