import java.util.Scanner;

public class Solution {
	static int[][] magnet = new int[4][8];
	static int[] idxs;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T;
		T= sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++)
		{
			int K = sc.nextInt();
			idxs = new int[4];
			int result = 0;
			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 8; j++) {
					magnet[i][j] = sc.nextInt();
				}
			}
			
			for (int i = 0; i < K; i++) {
				int[] directions = new int[4];
				getDirect(sc.nextInt() - 1, sc.nextInt(), directions);
				rotate(directions);
			}
			
			for (int i = 0; i < 4; i++) {
				if (magnet[i][idxs[i]] == 1) {
					result += (int) Math.pow(2, i);
				}
			}
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static void getDirect(int idx, int rotateDirection, int[] directions) {
		if (idx < 0 || idx >= 4) {
			return ;
		}
		directions[idx] = rotateDirection;
		if (idx > 0 && directions[idx-1] == 0 && magnet[idx][(idxs[idx] + 6) % 8] != magnet[idx-1][(idxs[idx-1] + 2) % 8]) {
			getDirect(idx - 1, rotateDirection * -1, directions);
		}
		if (idx < 3 && directions[idx+1] == 0 && magnet[idx][(idxs[idx] + 2) % 8] != magnet[idx+1][(idxs[idx+1] + 6) % 8]) {
			getDirect(idx + 1, rotateDirection * -1, directions);
		}
	}
	
	static void rotate(int[] directions) {
		for (int i = 0; i < 4; i++) {
			idxs[i] = (idxs[i] + directions[i] * (-1) + 8) % 8;
		}
	}
}