import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] nums = new int[N + 1];
		int[][] dp = new int[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < N+1; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i < N+1; i++) {
			dp[i][i] = 1;
			if (i < N && nums[i] == nums[i+1]) {
				dp[i][i+1] = 1;
			}
		}
		
		for (int d = 2; d < N; d++) {
			for (int i = 1; i < N; i++) {
				if (i+d <= N && dp[i+1][i + d - 1] == 1 && nums[i] == nums[i+d]) {
					dp[i][i+d] = 1;
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		int M = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			
			sb.append(dp[from][to]).append('\n');
		}
		System.out.println(sb);
	}
}