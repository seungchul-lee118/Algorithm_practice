import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        Stack<int[]> stack = new Stack<>();

        long count = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            int[] pair = new int[]{arr[i], 1};
            while (!stack.isEmpty() && arr[i] >= stack.peek()[0]) {
                int[] popped = stack.pop();
                count += popped[1];
                if (arr[i] == popped[0]) {
                    pair[1]+= popped[1];
                }
            }
            if (!stack.isEmpty()) {
                count++;
            }
            stack.push(pair);
        }

        System.out.println(count);
    }
}