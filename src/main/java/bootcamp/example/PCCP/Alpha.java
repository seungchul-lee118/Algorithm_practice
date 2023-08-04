package bootcamp.example.PCCP;

import java.util.*;

public class Alpha {
    public static void main(String[] args) {
        String s1 = "edeaaabbccd";

        System.out.println(solution(s1));
    }

    // 프로그래머스 PCCP 모의고사 #1 외톨이 알파벳

    public static String solution(String input_string) {
        String answer = "";
        int[] count = new int[26];
        List<Character> list = new ArrayList<>();
        Arrays.fill(count, -1);
        for (int i = 0; i < input_string.length(); i++) {
            int idx = input_string.charAt(i) - 'a';
            if (count[idx] != i - 1 && count[idx] != -1) {
                if (!list.contains(input_string.charAt(i))) {
                    System.out.println(i);
                    list.add(input_string.charAt(i));
                }
            }
            count[idx] = i;
        }
        System.out.println("list = " + list);
        Collections.sort(list);
        System.out.println("list = " + list);
        for (int i = 0; i < list.size(); i++) {
            answer += String.valueOf(list.get(i));
        }
        return answer;
    }
}
