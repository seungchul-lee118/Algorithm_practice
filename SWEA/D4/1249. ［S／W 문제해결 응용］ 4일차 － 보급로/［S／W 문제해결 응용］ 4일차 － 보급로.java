import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	// 특정 지점까지 가는 간선
	static class Node implements Comparable<Node>{
		int r;
		int c;
		int w;
		
		public Node(int r, int c, int w) {
			this.r = r;
			this.c = c;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}
	
	static final int INF = 987654321;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static int[][] map;
	static int[][] dist;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			//도로 파여진 도로의 깊이
			map = new int[N][N];
			//특정 지점까지 최소 복구 시간
			dist = new int[N][N];
			
			for (int i = 0; i < N; i++) {
				String s = sc.next();
				for (int j = 0; j < s.length(); j++) {
					map[i][j] = s.charAt(j) - '0';
				}
				//복구 시간 최대로 초기화
				Arrays.fill(dist[i], INF);
			}
			
			dijkstra(0, 0);
			
			System.out.println("#" + tc + " " + dist[N-1][N-1]);
		}
	}
	
	public static void dijkstra(int r, int c) {
		//방문여부
		boolean[][] visited = new boolean[N][N];
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		//시작지점 복구 시간 0
		dist[0][0] = 0;
		pq.add(new Node(0, 0, map[0][0]));
		
		while (!pq.isEmpty()) {
			Node node = pq.poll();
			
			//이미 최소 비용으로 알고 있을 때
			if (visited[node.r][node.c]) continue;
			
			visited[node.r][node.c] = true; 
			
			//사방탐색
			for (int i = 0; i < 4; i++) {
				int nextR = node.r + dr[i];
				int nextC = node.c + dc[i];
				//지도 안에 있고 && 최소 비용을 아직 모르고 && 현재 진행방으로 가는 것이 최소일 때
				if (inMap(nextR, nextC) && !visited[nextR][nextC]
						&& dist[nextR][nextC] > dist[node.r][node.c] + node.w) {
					//최소 복구 시간 = 이전 복구 시간 + 파여진 깊이
					dist[nextR][nextC] = dist[node.r][node.c]+ map[nextR][nextC];
					// 우선순위큐에 현재의 최소 복구 시간을 Node의 w로 입력해주어야 이전 최소시간 고려
					pq.add(new Node(nextR, nextC, dist[nextR][nextC]));
				}
			}
		}
	}

	public static boolean inMap(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}
}