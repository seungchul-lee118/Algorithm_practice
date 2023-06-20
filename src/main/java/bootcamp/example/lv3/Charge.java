package bootcamp.example.lv3;

import java.util.Arrays;

public class Charge {
    public static void main(String[] args) {
        int n = 5;
        int[] money = {1, 2, 5};

        System.out.println(solution(n, money));
    }

    // 프로그래머스 Lv.3 거스름돈

    public static int solution(int n, int[] money) {
        int answer = 0;
        int maxValue = 1000000007;
        Arrays.sort(money);
        int[] array = new int[n + 1];
        array[0] = 1;
        for (int i = 0; i < money.length; i++) {
            int nowMoney = money[i];
            for (int j = money[i]; j < n + 1; j++) {
                array[j] = (array[j - nowMoney] + array[j]) % maxValue;
            }
        }
        answer = array[n];
        return answer;
    }
}