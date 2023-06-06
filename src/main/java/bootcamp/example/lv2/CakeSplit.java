package bootcamp.example.lv2;

import java.util.*;

public class CakeSplit {
    public static void main(String[] args) {
        int[] topping1 = {1, 2, 1, 3, 1, 4, 1, 2};
        int[] topping2 = {1, 2, 3, 1, 4};
        System.out.println(solution(topping1));
        System.out.println(solution(topping2));
    }
    // 프로그래머스 lv.2 롤케이크 자르기
    public static int solution(int[] topping) {
        int answer = 0;
        Map<Integer, Integer> beforeMap = new HashMap<>();
        Map<Integer, Integer> afterMap = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            afterMap.put(topping[i], afterMap.getOrDefault(topping[i], 0)+1);
        }
        for (int i = 0; i < topping.length - 1; i++) {
            beforeMap.put(topping[i], beforeMap.getOrDefault(topping[i], 0)+1);
            if (afterMap.get(topping[i]).equals(1)) {
                afterMap.remove(topping[i]);
            } else {
                afterMap.put(topping[i], afterMap.get(topping[i]) - 1);
            }
            if (beforeMap.size() == afterMap.size()) {
                answer++;
            }
        }
        return answer;
    }
}
