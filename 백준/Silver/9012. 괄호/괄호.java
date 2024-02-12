import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int tc = 0; tc < N; tc++) {
            Stack<Character> stack = new Stack<>();
            String str = sc.next();
            boolean isVPS = true;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c == ')') {
                    if (stack.isEmpty()) {
                        isVPS = false;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty() && isVPS) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}