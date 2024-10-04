import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] map;
	static int[] dr = {0, 1, 0, -1};
	static int[] dc = {1, 0, -1, 0};
	static boolean[][] visited;
	static int[][] dist;

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
     	N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		visited = new boolean[N][M];
		dist = new int[N][M];

		for (int i = 0; i < N; i++) {
			String[] line = sc.next().split("");
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(line[j]);
			}
			Arrays.fill(dist[i], 123456789);
		}

		Queue<int[]> queue = new LinkedList<>();

		queue.offer(new int[] {0, 0});
		visited[0][0] = true;
		dist[0][0] = 1;

		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowR = now[0];
			int nowC = now[1];

			for (int i = 0; i < 4; i++) {
				int nextR = nowR + dr[i];
				int nextC = nowC + dc[i];

				if (nextR < 0 || nextR >= N || nextC < 0 || nextC >= M) continue;
				if (visited[nextR][nextC] || map[nextR][nextC] == 0) continue;

				queue.offer(new int[] {nextR, nextC});
				visited[nextR][nextC] = true;
				dist[nextR][nextC] = dist[nowR][nowC] + 1;
			}
		}
		System.out.println(dist[N - 1][M - 1]);
    }
}