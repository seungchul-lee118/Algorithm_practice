package bootcamp.example;

import java.util.Arrays;

public class Palindrome {
    public static void main(String[] args) {
        String s1 = "abcdcba";
        String s2 = "abacde";
        String s3 = "abccba";
        System.out.println(solution(s1));
        System.out.println(solution(s2));
        System.out.println(solution(s3));
    }

    // 프로그래머스 lv.3 가장 깉 펠린드롬
    public static int solution(String s)
    {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            int odd = palindrome(s, i, i);
            int even = palindrome(s, i, i + 1);
            answer = Math.max(answer, Math.max(odd, even));
        }

        return answer;
    }

    public static int palindrome(String s, int start, int end) {
        while (start >= 0 && end < s.length() && (s.charAt(start) == s.charAt(end))) {
            start--;
            end++;
        }
        return end - start - 1;
    }
}
