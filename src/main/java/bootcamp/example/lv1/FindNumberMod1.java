package bootcamp.example.lv1;

public class FindNumberMod1 {
    public static void main(String[] args) {
        int num1 = 10;
        int num2 = 12;

        System.out.println(solution(num1));
        System.out.println(solution(num2));
    }

    // 프로그래머스 lv.1 나머지가 1이 되는 수 찾기

    public static int solution(int n) {
        int answer = 0;
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
