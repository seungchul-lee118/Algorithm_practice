import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[][] adj = new int[N+1][N+1];
		int[] degree = new int[N+1];
		int[] depths = new int[N+1];
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			adj[a][b] = 1;
			degree[b]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < N+1; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
				depths[i] = 1;
			}
		}
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			
			for (int i = 1; i < N+1; i++) {
				if (adj[curr][i] == 1) {
					adj[curr][i] = 0;
					degree[i]--;
					
					if (degree[i] == 0) {
						queue.offer(i);
						depths[i] = depths[curr] + 1;
					}
				}
			}
		}
		
		for (int i = 1; i < N+1; i++) {
			sb.append(depths[i]).append(' ');
		}
		
		System.out.println(sb);
	}
}