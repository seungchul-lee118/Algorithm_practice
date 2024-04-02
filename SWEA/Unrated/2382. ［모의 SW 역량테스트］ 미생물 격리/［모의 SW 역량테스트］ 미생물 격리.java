import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M, K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //한 변에 있는 셀의 개수
			M = sc.nextInt(); //격리 시간
			K = sc.nextInt(); //미생물 군집의 개수
			
			int[][] minerals = new int[K][4];
			
			for (int i = 0; i < K; i++) {
				minerals[i] = new int[] {sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()-1};
			}
			
			for (int time = 1; time <= M; time++) {
				Map<Integer, List<Integer>> map = new HashMap<>();
				
				for (int idx = 0; idx < K; idx++) {
					if (minerals[idx][2] == 0) continue;
					int dir = minerals[idx][3];
					
					minerals[idx][0] += dr[dir];
					minerals[idx][1] += dc[dir];
					
					if (minerals[idx][0] == 0 || minerals[idx][0] == N-1
							|| minerals[idx][1] == 0 || minerals[idx][1] == N-1) {
						minerals[idx][2] /= 2;
						minerals[idx][3] ^= 1;
					}
					
					if (minerals[idx][2] == 0) continue;
					Integer position = minerals[idx][0] * 100 + minerals[idx][1];
					List<Integer> list = map.getOrDefault(position, new ArrayList<>());
					list.add(idx);
					map.put(position, list);
				}
				
				for (List<Integer> list : map.values()) {
					int maxValue = 0;
					int maxIdx = 0;
					int total = 0;
					
					for (Integer idx : list) {
						int value = minerals[idx][2];
						minerals[idx][2] = 0;
						total += value;
						if (value > maxValue) {
							maxIdx = idx;
							maxValue = value;
						}
					}
					
					minerals[maxIdx][2] = total;
				}
				
			}
			int answer = 0;
			for (int i = 0; i < K; i++) {
				answer += minerals[i][2];
			}
			System.out.println("#" + tc + " " + answer);
		}
	}
}
