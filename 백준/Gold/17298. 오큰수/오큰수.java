import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] arr = new int[N];
        int[] result = new int[N];
        StringBuilder builder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int idx = N - 1; idx >= 0; idx--) {
            if (stack.isEmpty()) {
                stack.push(idx);
                result[idx] = -1;
            } else {
                while (!stack.isEmpty()) {
                    Integer beforeIdx = stack.peek();
                    if (arr[idx] >= arr[beforeIdx]) {
                        stack.pop();
                    } else {
                        break;
                    }
                }
                if (stack.isEmpty()) {
                	result[idx] = -1;
                } else {
                	result[idx] = arr[stack.peek()];
                }
                stack.push(idx);
            }
        }
        for (int nge : result) {
        	builder.append(nge).append(' ');
        }
        System.out.println(builder);
    }
}