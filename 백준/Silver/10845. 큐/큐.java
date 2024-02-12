import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Deque<Integer> queue = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String str = sc.next();
            if (str.equals("push")) {
                int num = sc.nextInt();
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