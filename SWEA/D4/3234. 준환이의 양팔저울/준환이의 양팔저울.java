import java.util.Scanner;

public class Solution {
	static int[] weights;
	static int[] perm;
	static boolean[] visited;
	static int N;
	static int count;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			weights = new int[N];
			perm = new int[N];
			visited = new boolean[N];
			count = 0;
			
			for (int i = 0; i < N; i++) {
				weights[i] = sc.nextInt();
				
			}

			permutation(0);
			System.out.println("#" + tc + " " + count);
		}
    }
	
	static void permutation(int idx) {
		if (idx >= N) {
			backTrack(0, 0, 0);
		}
		for (int i = 0; i < N; i++) {
			if (visited[i]) continue;
			perm[idx] = weights[i];
			visited[i] = true;
			permutation(idx + 1);
			visited[i] = false;
		}
	}
	
	static void backTrack(int idx, int left, int right) {
		if (idx >= N) {
			count++;
			return;
		}
		backTrack(idx + 1, left, right + perm[idx]);
		if (left + perm[idx] <= right) {
			backTrack(idx + 1, left + perm[idx], right);
		}
	}
}