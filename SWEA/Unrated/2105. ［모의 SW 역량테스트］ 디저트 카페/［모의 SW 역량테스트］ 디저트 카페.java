import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static int N, counts, startr, startc;
	static int[][] map;
	static int[] dr = {1, 1, -1, -1};
	static int[] dc = {1, -1, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			counts = -1;
			map = new int[N][N];
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					map[r][c] = sc.nextInt();
				}
			}
			
			for (int r = 0; r < N-2; r++) {
				for (int c = 1; c < N-1; c++) {
					Set<Integer> set = new HashSet<>();
					set.add(map[r][c]);
					startr = r;
					startc = c;
					dfs(r + dr[0], c + dc[0], 0, set);
				}
			}
			
			System.out.println("#" + tc + " " + (counts == 1 ? -1 : counts));
		}
	}
	
	public static void dfs(int r, int c, int dir, Set<Integer> set) {
		if (dir == 3 && r == startr && c == startc) {
			counts = Math.max(counts, set.size());
			return ;
		}
		if (set.contains(map[r][c])) return ;
		
		if (dir < 3) {
			if (inMap(r + dr[dir], c + dc[dir])) {
				set.add(map[r][c]);
				dfs( r + dr[dir], c + dc[dir], dir, set);			
				set.remove(map[r][c]);
			}
			dir++;
			if (inMap(r + dr[dir], c + dc[dir])) {
				set.add(map[r][c]);
				dfs(r + dr[dir], c + dc[dir], dir, set);			
				set.remove(map[r][c]);
			}
		} else {
			if (r + c != startr + startc) return ;
			if (inMap(r + dr[dir], c + dc[dir])) {
				set.add(map[r][c]);
				dfs(r + dr[dir], c + dc[dir], dir, set);			
				set.remove(map[r][c]);
			}
		}
	}
	
	public static boolean inMap(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}