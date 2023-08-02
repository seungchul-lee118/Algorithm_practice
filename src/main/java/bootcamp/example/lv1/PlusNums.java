package bootcamp.example.lv1;

public class PlusNums {
    public static void main(String[] args) {
        int num1 = 123;
        int num2 = 987;

        System.out.println(solution(num1));
        System.out.println(solution(num2));
    }

    // 프로그래머스 lv.1 자릿수 더하기

    public static int solution(int n) {
        int answer = 0;
        String s = String.valueOf(n);
        for (int i = 0; i < s.length(); i++) {
            answer += s.charAt(i) - '0';
        }
        return answer;
    }
}
