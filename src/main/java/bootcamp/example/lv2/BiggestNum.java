package bootcamp.example.lv2;

import java.util.*;

public class BiggestNum {
    public static void main(String[] args) {
        int[] numbers1 = {6, 10, 2};
        int[] numbers2 = {3, 30, 34, 5, 9};

        System.out.println(solution(numbers1));
        System.out.println(solution(numbers2));
    }

    // 프로그래머스 lv.2 가장 큰 수
    public static String solution(int[] numbers) {
        String answer = "";
        String[] nums = new String[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            nums[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(nums, (o1,o2) ->
            Integer.parseInt(o2 + o1) - Integer.parseInt(o1 + o2)
        );

        for (String num : nums) {
            answer += num;
        }

        return answer.charAt(0) == '0' ? "0" : answer;
    }
}
