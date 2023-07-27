package bootcamp.example.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Compression {
    public static void main(String[] args) {
        String msg1 = "KAKAO";
        String msg2 = "TOBEORNOTTOBEORTOBEORNOT";
        String msg3 = "ABABABABABABABAB";

        System.out.println(Arrays.toString(solution(msg1)));
        System.out.println(Arrays.toString(solution(msg2)));
        System.out.println(Arrays.toString(solution(msg3)));
    }

    // 프로그래머스 lv.2 압축

    public static int[] solution(String msg) {
        List<Integer> answer = new ArrayList<>();
        List<String> list = new ArrayList<>();
        int idx = 0;
        int width = 1;

        for (int i = 0; i < 26; i++) {
            list.add(String.valueOf((char) ('A'+i)));
        }

        while (idx + width <= msg.length()) {
            String substring = msg.substring(idx, idx + width);
            if (!list.contains(substring)) {
                String beforeSubstring = msg.substring(idx, idx + width - 1);
                answer.add(list.indexOf(beforeSubstring) + 1);
                idx = idx + width - 1;
                width = 1;
                list.add(substring);
            } else {
                if (idx + width == msg.length()) {
                    answer.add(list.indexOf(msg.substring(idx)) + 1);
                }
                width++;
            }
        }

        return answer.stream().mapToInt(n -> n).toArray();
    }
}
