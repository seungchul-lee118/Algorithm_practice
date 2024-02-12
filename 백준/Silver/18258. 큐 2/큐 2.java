import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if (str.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                queue.offer(num);
            } else if (str.equals("pop")) {
                if (queue.isEmpty()) {
                    builder.append(-1).append('\n');
                } else {
                    builder.append(queue.pollFirst()).append('\n');
                }
            } else if (str.equals("size")) {
                builder.append(queue.size()).append('\n');
            } else if (str.equals("empty")) {
                if (queue.isEmpty()) {
                    builder.append(1).append('\n');
                } else {
                    builder.append(0).append('\n');
                }
            } else if (str.equals("front")) {
                if (queue.isEmpty()) {
                    builder.append(-1).append('\n');
                } else {
                    builder.append(queue.peek()).append('\n');
                }
            } else {
                if (queue.isEmpty()) {
                    builder.append(-1).append('\n');
                } else {
                    builder.append(queue.getLast()).append('\n');
                }
            }
        }
        System.out.println(builder);
    }
}