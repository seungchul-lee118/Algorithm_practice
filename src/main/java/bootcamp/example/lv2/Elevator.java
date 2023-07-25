package bootcamp.example.lv2;

import java.util.ArrayList;
import java.util.List;

public class Elevator {
    public static void main(String[] args) {
        int storey1 = 16;
        int storey2 = 2554;
        int storey3 = 0;
        int storey4 = 1;

        System.out.println(solution(storey1)); //6
        System.out.println(solution(storey2)); //16
        System.out.println(solution(storey3));
        System.out.println(solution(storey4));
    }

    // 프로그래머스 lv.2 마법의 엘리베이터

    public static int solution(int storey) {
        int answer = 1000000000;
        ArrayList<Integer> list = new ArrayList<>();
        dfs(storey, 0, list);
        for (Integer integer : list) {
            answer = Math.min(answer, integer);
        }
        return answer;
    }

    public static void dfs(int storey, int answer, List<Integer> list) {
        if (storey == 0) {
            list.add(answer);
            return ;
        }
        int lastNum = storey % 10;
        dfs(storey / 10, answer + lastNum, list);
        if (lastNum > 5 || storey > 10) {
            dfs((storey+ 10) / 10, answer + (10 - lastNum), list);
        }
    }

    //다른 사람 풀이
    public static int solution1(int storey) {
        int answer = 0;
        while (storey != 0) {
            int upperNumber = (storey % 100) / 10;
            int number = storey % 10;
            if (number > 5 || (number == 5 && upperNumber >= 5)) {
                storey += 10;
                answer += (10 - number);
            } else {
                answer += number;
            }
            storey = storey / 10;
        }
        return answer;
    }
}
