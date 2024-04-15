import java.util.*;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		Queue<int[]> queue = new LinkedList<int[]>();
		int N = sc.nextInt();
		int M = sc.nextInt();

		int[][] map = new int[N + 2][M + 2];
		for (int r = 0; r < N + 2; r++) {
			Arrays.fill(map[r], -1);
		}
		for (int r = 1; r < N + 1; r++) {
			String toInput = sc.next();
//            String toInput = "0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
			for (int c = 1; c < M + 1; c++) {
				map[r][c] = (int) toInput.charAt(c - 1) - 48;
			}
		}

		// dist에는 매 dequeue마다 최적의 값들을 저장한다.
//        int[][] dist = new int[N + 2][M + 2];
		boolean[][] breaked = new boolean[N + 2][M + 2];
		boolean[][] unbreaked = new boolean[N + 2][M + 2];
		int[] start = new int[] { 1, 1, 0, 1 };
		queue.add(start);
		int res = -1;
		while (!queue.isEmpty()) {
			int[] polled = queue.poll();
			if (polled[0] == N && polled[1] == M) {
				res = polled[3];
				break;
			}
			// 부쉈으면서 breaked 방문 or 안부쉈으면서 unbreaked 방문
			// 턴을 넘긴다.
			if ((polled[2] == 0 && unbreaked[polled[0]][polled[1]])
					|| (polled[2] == 1 && breaked[polled[0]][polled[1]]))
				continue;

			else {
				// visited 갱신해주기
				if (polled[2] == 0)
					unbreaked[polled[0]][polled[1]] = true;
				else
					breaked[polled[0]][polled[1]] = true;

				for (int i = 0; i < 4; i++) {
					int row = polled[0] + dr[i];
					int col = polled[1] + dc[i];

					// 맵밖으로 나가지 않는 경우에 한해서
					if (map[polled[0]][polled[1]] != -1) {
						// 부수지 않았을 경우
						if (polled[2] == 0) {
							// 길을 만났을 경우
							if (map[row][col] == 0) {
								int[] toqueue = { row, col, 0, polled[3] + 1 };
								queue.add(toqueue);
							}

							// 벽을 만났을 경우
							else {
								int[] toqueue = { row, col, 1, polled[3] + 1 };
								queue.add(toqueue);
							}
						}

						// 이미 부쉈을 경우
						else {
							// 길을 만났을 경우에만 queue
							if (map[row][col] == 0) {
								int[] toqueue = { row, col, 1, polled[3] + 1 };
								queue.add(toqueue);
							}
						}
					}
				}
			}
			
		}
		System.out.println(res);
	}
}

/*
 * for (int r = 0; r < N + 2; r++) { for (int c = 0; c < M + 2; c++) {
 * System.out.print(map[r][c]+" "); } System.out.println(); }
 */