import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static List<Integer>[] adjList;
	static boolean[] visited;
	static int[] counts;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int R = sc.nextInt();
		int Q = sc.nextInt();
		
		adjList = new List[N + 1];
		for (int i = 1; i <= N; i++) {
			adjList[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			adjList[a].add(b);
			adjList[b].add(a);
		}
		
		counts = new int[N+1];
		visited = new boolean[N+1];
		
		visited[R] = true;
		getCounts(R);
		
		for (int i = 0; i < Q; i++) {
			int subRoot = sc.nextInt();
			System.out.println(counts[subRoot]);
		}
	}
	
	public static int getCounts(int node) {
		int count = 1;
		
		if (counts[node] == 0) {
			for (int next : adjList[node]) {
				if (visited[next]) continue;
				visited[next] = true;
				count += getCounts(next);
			}
			counts[node] = count;
		}
		return counts[node];
	}
}