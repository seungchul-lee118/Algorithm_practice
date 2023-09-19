package bootcamp.example.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JoyStick {
    public static void main(String[] args) {
        String name1 = "JEROEN";
        String name2 = "JAN";

        System.out.println(solution(name1));
        System.out.println(solution(name2));
    }

    // 프로그래머스 lv.2 조이스틱

    public static int solution(String name) {
        int answer = 0;

        for (int i = 0; i < name.length(); i++) {
            int idx = name.charAt(i) - 'A';
            answer += Math.min(idx, 26 - idx);
        }

        int frontIdx = 0;
        int backIdx = 0;
        int minParallel = 1000;

        while (backIdx < name.length()) {
            int backward = name.length() - backIdx;
            int forward = frontIdx;
            int parallel = forward + backward + Math.min(forward, backward);

            minParallel = Math.min(minParallel, parallel);

            frontIdx = backIdx;
            backIdx++;
            while(backIdx < name.length() && name.charAt(backIdx) == 'A')
                backIdx++;
        }
        minParallel = Math.min(minParallel, frontIdx);
        answer += minParallel;
        return answer;
    }
}