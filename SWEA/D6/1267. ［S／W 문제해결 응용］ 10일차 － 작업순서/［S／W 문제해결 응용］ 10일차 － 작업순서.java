
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			int V = sc.nextInt();
			int E = sc.nextInt();
			
			//인접행렬
			int[][] adj = new int[V+1][V+1];
			//진입차수
			int[] degree = new int[V+1];
			
			for (int i = 0; i < E; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				adj[a][b] = 1;
				degree[b]++;
			}
			
			Queue<Integer> queue = new LinkedList<>();
			StringBuilder sb = new StringBuilder();
			
			// 진입차수가 0인 정점 queue에 추가
			for (int i = 1; i < V+1; i++) {
				if (degree[i] == 0) {
					queue.offer(i);
				}
			}
			
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				sb.append(curr).append(' ');
				
				//curr 정점과 연결된 간선 삭제
				for (int i = 1; i < V+1; i++) {
					if (adj[curr][i] == 1) {
						adj[curr][i] = 0;
						degree[i]--;
						if (degree[i] == 0) {
							queue.offer(i);
						}
					}
				}
			}
			System.out.println("#" + tc + " " + sb);
		}
	}
}
