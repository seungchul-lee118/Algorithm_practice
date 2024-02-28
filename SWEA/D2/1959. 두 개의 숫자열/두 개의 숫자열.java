import java.util.Scanner;

public class Solution {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[] arr1 = new int[N];
			int[] arr2 = new int[M];
			
			int maxSum = 0;
			
			for (int i = 0; i < N; i++) {
				arr1[i] = sc.nextInt();
			}
			
			for (int i = 0; i < M; i++) {
				arr2[i] = sc.nextInt();
			}
			
			for (int outer = 0; outer <= Math.abs(N-M); outer++) {
				int sum = 0;
				for (int inner = 0; inner < Math.min(N, M); inner++) {
					if (N < M) {
						sum += arr1[inner] * arr2[outer + inner];
					} else {
						sum += arr2[inner] * arr1[outer + inner];						
					}
				}
				maxSum = Math.max(maxSum, sum);
			}
			
			System.out.println("#" + tc + " " + maxSum);
		}
    }
}