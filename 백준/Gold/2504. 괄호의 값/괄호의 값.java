import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.next().split("");
        Stack<String> stack = new Stack<>();
        long result = 0;
        boolean isCorrect = true;

        for (int i = 0; i < str.length; i++) {
            String s = str[i];

            if (s.equals(")") || s.equals("]")) {
                if (stack.isEmpty()) {
                    isCorrect = false;
                    break;
                } else {
                    long sum = 0;
                    while (!stack.isEmpty() && !stack.peek().equals("(") && !stack.peek().equals("[")) {
                        sum += Long.parseLong(stack.pop());
                    }
                    if (stack.isEmpty()
                        || s.equals(")") && stack.peek().equals("[")
                        || s.equals("]") && stack.peek().equals("(")) {
                        isCorrect = false;
                        break;
                    }
                    sum = sum == 0 ? 1 : sum;
                    String last = stack.pop();
                    if (last.equals("(")) {
                        stack.push(String.valueOf(2 * sum));
                    } else {
                        stack.push(String.valueOf(3 * sum));
                    }

                }
            } else {
                stack.push(s);
            }
        }

        while (!stack.isEmpty() && isCorrect) {
            String popped = stack.pop();
            if (popped.equals("(") || popped.equals("[")) {
                result = 0;
                break;
            }
            result += Long.parseLong(popped);
        }
        System.out.println(result);
    }
}