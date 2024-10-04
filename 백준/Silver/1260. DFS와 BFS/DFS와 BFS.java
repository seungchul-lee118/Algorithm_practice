import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N;
	static int M;
	static int[][] adj;
	static String result1;
	static String result2;

    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
     	N = sc.nextInt();
		M = sc.nextInt();
		int V = sc.nextInt();
		adj = new int[N+1][N+1];
		result1 = "";
		result2 = "";

		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adj[a][b] = 1;
			adj[b][a] = 1;
		}

		dfs(V, new boolean[N+1]);
		bfs(V);
		System.out.println(result1);
		System.out.println(result2);
    }

	static void dfs(int node, boolean[] visited) {
		visited[node] = true;
		result1 += node;

		for (int i = 1; i <= N; i++) {
			if (!visited[i] && adj[node][i] == 1) {
				result1 += " ";
				dfs(i, visited);
			}
		}
	}

	static void bfs(int node) {
		boolean[] visited = new boolean[N + 1];
		Queue<Integer> queue = new LinkedList<>();

		result2 += node;
		queue.offer(node);
		visited[node] = true;

		while (!queue.isEmpty()) {
			Integer poll = queue.poll();

			for (int i = 1; i <= N; i++) {
				if (!visited[i] && adj[poll][i] == 1) {
					result2 += " " + i;
					visited[i] = true;
					queue.offer(i);
				}
			}
		}
	}
}
