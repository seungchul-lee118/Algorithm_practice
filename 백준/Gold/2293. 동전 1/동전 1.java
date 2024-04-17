import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		int[][] dp = new int[N][k+1];
		int[] coins = new int[N];
		
		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}
		
		for (int i = 0; i <= k; i++) {
			if (i % coins[0] == 0) {
				dp[0][i] = 1;
			}
		}
		
		for (int n = 1; n < N; n++) {
			for (int i = 0; i <= k; i++) {
				if (i >= coins[n]) {
					dp[n][i] = dp[n-1][i] + dp[n][i-coins[n]];
				} else {
					dp[n][i] = dp[n-1][i];
				}
			}
		}
		System.out.println(dp[N-1][k]);
		
	}
}