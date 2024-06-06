import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {0, 0};
        int ones, zeros;
        ones = zeros = 0;
        while (ones != 1) {
            ones = zeros = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            answer[0]++;
            answer[1]+= zeros;
            s = Integer.toBinaryString(ones);
        }
        return answer;
    }
}