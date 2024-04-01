import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			//접수 창구 수
			int N = sc.nextInt();
			//정비 창구 수
			int M = sc.nextInt();
			//방문한 고객의 수
			int K = sc.nextInt();
			int answer = 0;
			
			//접수 창구 번호
			int A = sc.nextInt();
			//정비 창구 번호
			int B = sc.nextInt();
			
			//접수 처리 시간
			int[] ai = new int[N + 1];
			//정비 처리 시간
			int[] bi = new int[M + 1];
			//고객 도착 시간
			int[] ti = new int[K + 1];
			
			for (int i = 1; i < N+1; i++) {
				ai[i] = sc.nextInt();
			}
			for (int i = 1; i < M+1; i++) {
				bi[i] = sc.nextInt();
			}
			for (int i = 1; i < K+1; i++) {
				ti[i] = sc.nextInt();
			}
			
			//작업이 빨리 끝나는 순간, 작업 시간이 동일하면 빠른 창구 기준으로 정렬
			PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
			});
			
			//접수 창구 작업 완료 시간
			int[] receptions = new int[N+1];
			//정비 창구 작업 완료 시간
			int[] repairs = new int[M+1];
			
			for (int i = 1; i < K+1; i++) {
				int time = ti[i];
				int minIdx = 1;
				
				//접수 가장 빨리 끝나는 창구 찾기
				for (int a = 1; a < N+1; a++) {
					if (receptions[a] < receptions[minIdx]) {
						minIdx = a;
					}
				}
				
				//가장 빨리 끝나는 것보다 고객 도착시간이 빠를 경우
				if (time < receptions[minIdx]) {
					pq.offer(new int[] {receptions[minIdx] + ai[minIdx], minIdx, i});
					receptions[minIdx] += ai[minIdx];
				} else {
					//도착했을 때 바로 접수 가능한 창구가 있을 때
					for (int a = 1; a < N+1; a++) {
						if (time >= receptions[a]) {
							pq.offer(new int[] {time + ai[a], a, i});
							receptions[a] = time + ai[a];
							break;
						}
					}
				}
			}
			
			while (!pq.isEmpty()) {
				int[] curr = pq.poll();
				int time = curr[0];
				int rec = curr[1];
				int client = curr[2];
				
				int minIdx = 1;
				
				for (int b = 1; b < M+1; b++) {
					if (repairs[b] < repairs[minIdx]) {
						minIdx = b;
					}
				}
				
				if (time < repairs[minIdx]) {					
					if (rec == A && minIdx == B) {
						answer += client;
					}
					repairs[minIdx] += bi[minIdx];
				} else {
					for (int b = 1; b < M+1; b++) {
						if (time >= repairs[b]) {
							if (rec == A && b == B) {
								answer += client;
							}
							repairs[b] = time + bi[b];
							break;
						}
					}
				}
			}
				
			System.out.println("#" + tc + " " + (answer == 0 ? -1 : answer));
		}
	}	
}
