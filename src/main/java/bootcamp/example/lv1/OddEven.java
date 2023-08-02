package bootcamp.example.lv1;

public class OddEven {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 4;

        System.out.println(solution(num1));
        System.out.println(solution(num2));
    }

    // 프로그래머스 lv.1 짝수와 홀수

    public static String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
