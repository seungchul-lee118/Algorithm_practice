import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List<Integer>[] adj = new ArrayList[N+1];
		int[] degree = new int[N+1];
		
		for (int i = 0; i < N+1; i++) {
			adj[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			adj[a].add(b);
			degree[b]++;
		}
		
		Queue<Integer> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 1; i < N+1; i++) {
			if (degree[i] == 0) {
				queue.offer(i);
			}
		}
		
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			sb.append(curr).append(' ');
			
			for (Integer num : adj[curr]) {
				degree[num]--;
				
				if (degree[num] == 0) {
					queue.offer(num);
				}
			}
		}

		System.out.println(sb);
	}
}