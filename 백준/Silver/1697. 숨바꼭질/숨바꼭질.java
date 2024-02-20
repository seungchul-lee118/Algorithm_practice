import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        Queue<int[]> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[100000 + 2];
        int seconds = 0;

        queue.offer(new int[]{N, 0});
        isVisited[N] = true;

        while (!queue.isEmpty()) {
            int[] now =queue.poll();
            if (now[0] == K) {
                seconds = now[1];
                break;
            }
            if (now[0] + 1 <= 100000 && !isVisited[now[0] + 1]) {
                isVisited[now[0] + 1] = true;
                queue.offer(new int[]{now[0] + 1, now[1] + 1});
            }
            if (0 <= now[0] - 1 && now[0] - 1 <= 100000 && !isVisited[now[0] - 1]) {
                isVisited[now[0] - 1] = true;
                queue.offer(new int[]{now[0] - 1, now[1] + 1});
            }
            if (now[0] * 2 <= 100000 && !isVisited[now[0] * 2]) {
                isVisited[now[0] * 2] = true;
                queue.offer(new int[]{now[0] * 2, now[1] + 1});
            }
        }
        System.out.println(seconds);
    }
}