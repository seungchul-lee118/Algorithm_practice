import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        boolean isOk = true;
        int start = 0;

        for (int i = 0; i < N; i++) {
            int nextNum = Integer.parseInt(br.readLine());
            
            if (start < nextNum) {
                for (int j = start + 1; j <= nextNum; j++) {
                    stack.push(j);
                    builder.append('+').append('\n');
                }
                start = nextNum;
            }
            if (stack.peek() != nextNum) {
                isOk = false;
            } else {
                stack.pop();
                builder.append('-').append('\n');
            }
        }
        if (isOk) {
            System.out.println(builder);
        } else {
            System.out.println("NO");
        }
    }
}