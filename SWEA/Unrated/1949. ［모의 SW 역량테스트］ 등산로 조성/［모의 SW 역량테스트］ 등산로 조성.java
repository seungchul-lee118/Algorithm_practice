import java.util.Scanner;

public class Solution {
	static int N, K, length;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			length = 0;
			map = new int[N][N];
			visited = new boolean[N][N];
			int maxH = 0;
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
					maxH = Math.max(maxH, map[r][c]);
				}
			}
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (map[r][c] == maxH) {
						visited[r][c] = true;
						dfs(r, c, 1, false);
						visited[r][c] = false;
					}
				}
			}
			
			System.out.println("#" + tc + " " + length);
		}
	}
	
	public static void dfs(int r, int c, int count, boolean done) {
		boolean check = true;
		
		for (int i = 0; i < 4; i++) {
			int nextr = r + dr[i];
			int nextc = c + dc[i];
			if (!inMap(nextr, nextc) || visited[nextr][nextc]) continue;
			
			if (map[nextr][nextc] < map[r][c]) {
				visited[nextr][nextc] = true;
				dfs(nextr, nextc, count + 1, done);
				visited[nextr][nextc] = false;
				check = false;
			} else if (!done && map[nextr][nextc] - map[r][c] < K) {
				int temp = map[nextr][nextc];
				visited[nextr][nextc] = true;
				map[nextr][nextc] = map[r][c] - 1;
				dfs(nextr, nextc, count + 1, true);
				map[nextr][nextc] = temp;
				visited[nextr][nextc] = false;
				check = false;
			}
		}
		if (check) length = Math.max(length, count);
	}
	
	public static boolean inMap(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}
