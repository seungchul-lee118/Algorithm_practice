package bootcamp.example.lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class DoublePriorityQueue {
    public static void main(String[] args) {
        String[] operation1 = {"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] operation2 = {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};

        System.out.println(Arrays.toString(solution(operation1)));
        System.out.println(Arrays.toString(solution(operation2)));
    }

    // 프로그래머스 lv.3 이중우선순위큐

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> pQMin = new PriorityQueue<>();
        PriorityQueue<Integer> pQMax = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i=0; i<operations.length; i++) {
            String[] operation = operations[i].split(" ");
            if (operation[0].equals("I")) {
                pQMin.add(Integer.valueOf(operation[1]));
                pQMax.add(Integer.valueOf(operation[1]));
            } else {
                if (pQMin.isEmpty()) {
                    continue;
                }
                Integer val = Integer.valueOf(operation[1]);
                if (val.equals(1)) {
                    pQMin.remove(pQMax.poll());
                } else {
                    pQMax.remove(pQMin.poll());
                }
            }
        }
        if (pQMin.isEmpty()) {
            return answer;
        }

        answer[0] = pQMax.peek();
        answer[1] = pQMin.peek();

        return answer;
    }
}
