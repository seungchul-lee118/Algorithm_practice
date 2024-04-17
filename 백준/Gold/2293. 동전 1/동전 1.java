import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		int[] dp = new int[k+1];
		int[] coins = new int[N];
		
		for (int i = 0; i < N; i++) {
			coins[i] = sc.nextInt();
		}
		
		for (int i = 0; i <= k; i++) {
			if (i % coins[0] == 0) {
				dp[i] = 1;
			}
		}
		
		for (int n = 1; n < N; n++) {
			for (int i = 0; i <= k; i++) {
				if (i >= coins[n]) {
					dp[i] = dp[i] + dp[i-coins[n]];
				}
			}
		}
		System.out.println(dp[k]);
	}
}