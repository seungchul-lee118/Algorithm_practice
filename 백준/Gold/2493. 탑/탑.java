import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder builder = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[N];

        Stack<Integer> stack = new Stack<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        for (int idx = 0; idx < arr.length; idx++) {
            if (stack.isEmpty()) {
                stack.push(idx + 1);
                builder.append(0).append(' ');
            } else {
                while (!stack.isEmpty()) {
                    Integer beforeIdx = stack.peek() - 1;
                    if (arr[idx] > arr[beforeIdx]) {
                        stack.pop();
                    } else {
                        builder.append(stack.peek()).append(' ');
                        break;
                    }
                }
                if (stack.isEmpty()) {
                    builder.append(0).append(' ');
                }
                stack.push(idx + 1);
            }
        }
        System.out.println(builder);

    }
}