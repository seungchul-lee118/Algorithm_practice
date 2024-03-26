import java.util.Scanner;

public class Solution {
	static int[] pays;
	static int[] plans;
	static int minTotal;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			pays = new int[4];
			plans = new int[12];
			
			for (int i = 0; i < 4; i++) {
				pays[i] = sc.nextInt();
			}
			for (int i = 0; i < 12; i++) {
				plans[i] = sc.nextInt();
			}
			
			minTotal = pays[3];
			dfs(0, 0);
			minTotal = Math.min(pays[3], minTotal);
			
			System.out.println("#" + tc + " " + minTotal);
		}
	}
	
	public static void dfs(int month, int sum) {
		if (month >= 12) {
			minTotal = Math.min(minTotal, sum);
			return ;
		}
		
		dfs(month + 1, sum + plans[month] * pays[0]);
		if (plans[month] != 0) {
			dfs(month + 1, sum + pays[1]);
			dfs(month + 3, sum + pays[2]);			
		}
	}
}