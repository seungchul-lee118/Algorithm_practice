package bootcamp.example;

import java.util.Arrays;

public class Country124 {
    public static void main(String[] args) {
        System.out.println(solution(1));
        System.out.println(solution(2));
        System.out.println(solution(3));
        System.out.println(solution(4));
        System.out.println(solution(5));
        System.out.println(solution(6));
        System.out.println(solution(7));
        System.out.println(solution(8));
        System.out.println(solution(9));
        System.out.println(solution(10));
    }

    // 프로그래머스 lv.2 124 나라의 숫자

    public static String solution(int n) {
        StringBuilder builder = new StringBuilder();
        while (n > 0) {
            int num = n % 3;
            if (num == 0) {
                builder.append(4);
            } else {
                builder.append(num);
            }
            n = (n-1) / 3;
        }
        return builder.reverse().toString();
    }
}
