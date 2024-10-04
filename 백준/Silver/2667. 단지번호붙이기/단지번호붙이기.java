import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static int[][] map;
	static boolean[][] visited;

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
     	int N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String[] split = sc.next().split("");
			for (int j = 0; j < split.length; j++) {
				map[i][j] = Integer.parseInt(split[j]);
			}
		}

		Queue<int[]> queue = new LinkedList<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (visited[r][c] || map[r][c] == 0) continue;
				
				queue.offer(new int[] {r, c});
				visited[r][c] = true;

				int count = 1;

				while (!queue.isEmpty()) {
					int[] now = queue.poll();

					for (int i = 0; i < 4; i++) {
						int nextR = now[0] + dr[i];
						int nextC = now[1] + dc[i];

						if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= N) continue;
						if (visited[nextR][nextC] || map[nextR][nextC] == 0) continue;
						
						queue.offer(new int[] {nextR, nextC});
						visited[nextR][nextC] = true;
						count++;
					}
				}
				pq.offer(count);
			}
		}
		System.out.println(pq.size());
		while (!pq.isEmpty()) {
			System.out.println(pq.poll());
		}
    }
}