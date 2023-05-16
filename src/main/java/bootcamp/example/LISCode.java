package bootcamp.example;

import java.util.*;

public class LISCode {
    public static void main(String[] args) {
        int output = LIS(new int[]{7, 2, 5, 3, 4, 9, 1, 10, 2});
        System.out.println(output);
    }

    public static int LIS(int[] arr) {
        // TODO:
        Stack<Integer> stack = new Stack<>();
        List<Integer[]> totalSubLIS = new ArrayList<>();

        totalSubLIS = totalLIS(totalSubLIS, stack, 0, arr);

        System.out.println(totalSubLIS.stream().mapToInt(n -> n.length).max().orElse(0));
        return 0;
    }

    public static List<Integer[]> totalLIS(List<Integer[]> totalSubLIS, Stack<Integer> stack,
                                           int idx, int[] arr) {
        if (idx == arr.length) {
            totalSubLIS.add(stack.toArray(new Integer[0]));
            System.out.println("stack = " + stack);
            return totalSubLIS;
        } else {
            if (stack.isEmpty() || stack.peek() < arr[idx]) {
                stack.add(arr[idx]);
                totalLIS(totalSubLIS, stack, idx + 1, arr);
                stack.pop();
                totalLIS(totalSubLIS, stack, idx + 1, arr);
            } else {
                totalLIS(totalSubLIS, stack, idx + 1, arr);
            }
        }
        return totalSubLIS;
    }


}
