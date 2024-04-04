import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] pays = {1, 5, 10, 50, 100, 500, 1000, 5000};
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			N /= 10;
			int[] count = new int[pays.length];
			StringBuilder builder = new StringBuilder();
			
			for (int i = pays.length - 1; i >= 0; i--) {
				count[i] = N / pays[i];
				N = N % pays[i];
			}
			
			for (int i = count.length-1; i >= 0; i--) {
				builder.append(count[i]).append(' ');
			}
			
			System.out.println("#" + tc);
			System.out.println(builder);
		}
	}
}