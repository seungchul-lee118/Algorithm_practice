package bootcamp.example.lv1;

public class Divisor {
    public static void main(String[] args) {
        int n1 = 12;
        int n2 = 5;

        System.out.println(solution(n1));
        System.out.println(solution(n2));
    }

    // 프로그래머스 lv.1 약수의 합

    public static int solution(int n) {
        int answer = 0;
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                answer += i == Math.sqrt(n) ? i : i + n / i;
            }
        }
        return answer;
    }
}
