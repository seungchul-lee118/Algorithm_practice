import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	static int[] village;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T;
		T= sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			Set<Integer> set = new HashSet<>();
			
			village = new int[N + 1];
			
			for (int i = 1; i < N + 1; i++) {
				village[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				union(sc.nextInt(), sc.nextInt());
			}
			
			for (int i = 1; i <= N; i++) {
				find(i);
			}
			
			for (int i = 1; i <= N; i++) {
				set.add(village[i]);
			}

			System.out.println("#" + tc + " " + set.size());
		}
	}
	
	static void union(int a, int b) {
		int roota = find(a);
		int rootb = find(b);
		village[rootb] = roota;
	}
	
	static int find(int a) {
		if (a != village[a]) {
			return village[a] = find(village[a]);
		}
		return village[a];
	}
}