package bootcamp.example.lv2;

import java.util.*;

public class ParcelBox {
    public static void main(String[] args) {
        int[] order1 = {4, 3, 1, 2, 5};
        int[] order2 = {5, 4, 3, 2, 1};

        System.out.println(solution(order1));
        System.out.println(solution(order2));
    }

    // 프로그래머스 lv.2 택배상자

    public static int solution(int[] order) {
        int answer = 0;
        int idx = 0;
        Stack<Integer> addConv = new Stack<>();
        Queue<Integer> origConv = new LinkedList<>();

        for (int i = 1; i <= order.length; i++) {
            origConv.add(i);
        }

        while (!origConv.isEmpty() || !addConv.isEmpty()) {
            if (!origConv.isEmpty() && order[idx] == origConv.peek()) {
                origConv.poll();
                answer++;
                idx++;
            } else if (!addConv.isEmpty() && order[idx] == addConv.peek()) {
                addConv.pop();
                answer++;
                idx++;
            } else if (!origConv.isEmpty()) {
                addConv.add(origConv.poll());
            } else {
                break;
            }
        }

        return answer;
    }
}
