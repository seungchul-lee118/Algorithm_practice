import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	static int[] p;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		p = new int[V+1];
		for (int i = 1; i < V+1; i++) {
			p[i] = i;
		}
		
		int[][] edges = new int[E][3];
		
		for (int i = 0; i < E; i++) {
			edges[i] = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt()};
		}
		
		Arrays.sort(edges, Comparator.comparing(o -> o[2]));
		
		long answer = 0;
		int pick = 0;
		
		for (int i = 0; i < E; i++) {
			int px = find(edges[i][0]);
			int py = find(edges[i][1]);
			if (px != py) {
				union(px, py);
				answer += edges[i][2];
				pick++;
			}
			if (pick == V - 1) break;
		}
		
		System.out.println(answer);
	}
	
	static void union(int a, int b) {
		p[b] = a;
	}
	
	static int find(int a) {
		if (a != p[a]) {
			return p[a] = find(p[a]);
		}
		return p[a];
	}
}