import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		
		for (int tc = 1; tc <= T; tc++) {
			int L = sc.nextInt();
			int start = sc.nextInt();
			
			//부여번호 1~100, 인접행렬 101x101 로 정의
			int[][] adjArr = new int[101][101];
			//시작점에서부터 특정 번호까지의 거리 저장 배열
			int[] dist = new int[101];
			
			//{from, to, from, to, ...} 형태의 입력이므로 데이터의 길이 / 2 꺄지
			for (int i = 0; i < L / 2; i++) {
				int s = sc.nextInt();
				int e = sc.nextInt();
				// 동일한 {from, to} 쌍이 여러번 반복되는 경우도 있기 때문에
				// 인접행렬이 0일 때만 간선 연결
				if (adjArr[s][e] == 0) {
					adjArr[s][e] = 1;
				}
			}

			//bfs 탐색
			Queue<Integer> queue = new ArrayDeque<>();
			
			//시작점
			queue.add(start);
			//가장 나중에 받게 되는 사람까지의 거리
			int maxDepth = 0;
			
			while (!queue.isEmpty()) {
				int curr = queue.poll();
				
				//인접행렬 순회
				for (int i = 1; i < 101; i++) {
					//간선 연결이 되어 있고 이전에 연락받지 않은 경우
					if (adjArr[curr][i] != 0 && dist[i] == 0) {
						queue.add(i);
						//얼마만에 연락받았는지 dist[i] 계산
						dist[i] = dist[curr] + adjArr[curr][i];
						//가장 나중에 몇 번째에 연락을 받는지
						maxDepth = dist[i];
					}
				}
			}
			
			//가장 나중에 연락을 받게 되는 사람 중 번호가 큰 사람
			int ans = 0;
			for (int i = 0; i < 101; i++) {
				if (dist[i] == maxDepth) ans = i;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
	}
}