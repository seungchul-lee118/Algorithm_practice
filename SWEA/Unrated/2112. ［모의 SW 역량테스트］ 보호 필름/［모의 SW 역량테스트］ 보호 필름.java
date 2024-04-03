import java.util.Scanner;

public class Solution {
	static int D, W, K, count;
	static int[][] cells;
	static int[] paint;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			D = sc.nextInt();
			W = sc.nextInt();
			K = sc.nextInt();
			count = K;
			cells = new int[D][W];
			
			
			for (int r = 0; r < D; r++) {
				for (int c = 0; c < W; c++) {
					cells[r][c] = sc.nextInt();
				}
			}
			
			paint = new int[D];
			
			for (int i = 0; i < K; i++) {
				if (i > count) break;
				comb(i, 0, 0);
			}
			
			if (K == 1) {
				System.out.println("#" + tc + " " + 0);
				continue;
			}
			System.out.println("#" + tc + " " + count);
		}
	}
	
	public static void comb(int r, int sidx, int idx) {
		if (sidx >= r) {
			inspect(r);
			return;
		}
		
		if (idx >= D) {
			return ;
		}
		
		paint[idx] = 1;
		comb(r, sidx+1, idx+1);
		paint[idx] = 2;	
		comb(r, sidx+1, idx+1);
		
		paint[idx] = 0;
		comb(r, sidx, idx+1);
	}
	
	public static void inspect(int paints) {
		int temp = 0;
		
		for (int c = 0; c < W; c++) {
			boolean valid = false;
			int first = cells[0][c];
			
			if (paint[0] == 1) first = 0;
			else if (paint[0] == 2) first = 1;
			
			int tempCount = 1;
			
			for (int r = 1; r < D; r++) {
				int second = cells[r][c];
				
				if (paint[r] == 1) second = 0;
				else if (paint[r] == 2) second = 1;
				
				if (second == first) {
					tempCount++;
					if (tempCount == K) {
						temp++;
						valid = true;
						break;
					}
				} else {
					tempCount = 1;
					first = second;
				}
			}
			if (!valid) break;
		}
		
		if (temp == W) count = Math.min(count, paints);
	}
}
