import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] arr = new long[N];
        long count = 0;

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        for (int idx = N - 1; idx >= 0; idx--) {
            if (stack.isEmpty()) {
                stack.push(idx);
            } else {
                while (!stack.isEmpty()) {
                    Integer beforeIdx = stack.peek();
                    if (arr[idx] > arr[beforeIdx]) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                if (stack.isEmpty()) {
                	count += (N - idx - 1);
                } else {
                	count += (stack.peek() - idx - 1);
                }
                stack.push(idx);
            }
        }
        System.out.println(count);
    }
}