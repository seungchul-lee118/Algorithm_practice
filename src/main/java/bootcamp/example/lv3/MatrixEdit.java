package bootcamp.example.lv3;

import java.util.*;

public class MatrixEdit {
    public static void main(String[] args) {
        int n1 = 8;
        int k1 = 2;
        String[] cmd1 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        int n2 = 8;
        int k2 = 2;
        String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};

        System.out.println(solution(n1, k1, cmd1));
        System.out.println(solution(n2, k2, cmd2));
    }

    // 프로그래머스 lv.3 표 편집

    public static String solution(int n, int k, String[] cmd) {
        StringBuilder builder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int tableSize = n;
        for (int i = 0; i < cmd.length; i++) {
            String[] split = cmd[i].split(" ");
            String action = split[0];
            if (action.equals("D")) {
                k += Integer.parseInt(split[1]);
            } else if (action.equals("U")) {
                k -= Integer.parseInt(split[1]);
            } else if (action.equals("C")) {
                stack.push(k);
                tableSize--;
                if (k == tableSize) {
                    k--;
                }
            } else {
                if (stack.pop() <= k) {
                    k++;
                }
                tableSize++;
            }
        }
        for (int i = 0; i < tableSize; i++) {
            builder.append("O");
        }
        while (!stack.isEmpty()) {
            builder.insert(stack.pop(), "X");
        }
        return builder.toString();
    }

}
