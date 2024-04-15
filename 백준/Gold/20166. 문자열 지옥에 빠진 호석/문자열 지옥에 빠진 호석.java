

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 1, 0, 0, -1, 1, -1, 1 };
	static int[] dc = { 0, 0, -1, 1, 1, 1, -1, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		char[][] map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String input = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		HashMap<String, Integer> allChar = new HashMap<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++)
				bfs(map, i, j, allChar);
		}
		
		StringBuilder sb= new StringBuilder();
		for(int i =0 ; i<K; i++)
			sb.append(allChar.getOrDefault(in.readLine(), 0)).append("\n");
		
		System.out.println(sb);
	}

	private static void bfs(char[][] map, int r, int c, HashMap<String, Integer> allChar) {
		// TODO Auto-generated method stub
		Queue<String_Val> queue = new ArrayDeque<>();
		queue.add(new String_Val(r, c, 1, "" + map[r][c]));
		while (!queue.isEmpty()) {
			String_Val current = queue.poll();
			allChar.put(current.s, allChar.getOrDefault(current.s, 0)+1);
			
			if (current.length < 5) {
				for (int d = 0; d < 8; d++) {
					int nr = (current.r + dr[d] + map.length) % map.length;
					int nc = (current.c + dc[d] + map[0].length) % map[0].length;
					String nextString = current.s + map[nr][nc];
					int nl = current.length + 1;
					queue.add(new String_Val(nr, nc, nl, nextString));
				}
			}
		}
	}
}

class String_Val {
	int r;
	int c;
	int length;
	String s;

	String_Val(int r, int c, int length, String s) {
		this.r = r;
		this.c = c;
		this.s = s;
		this.length = length;
	}
}
