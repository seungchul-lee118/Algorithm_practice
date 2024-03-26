import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int[][] cheese;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
        int N = sc.nextInt();
        cheese = new int[N][N];
        int maxNum = 0;
        int maxCount = 1;

        // 치즈 맛 중
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cheese[i][j] = sc.nextInt();
                maxNum = Math.max(maxNum, cheese[i][j]);
            }
        }

        for (int i = 1; i <= maxNum; i++) {
            boolean[][] visited = new boolean[N][N];
            Queue<int[]> queue = new LinkedList<>();
            int count = 0;

            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (visited[r][c] || cheese[r][c] <= i) continue;
                    queue.add(new int[] {r, c});
                    visited[r][c] = true;
                    count++;

                    while (!queue.isEmpty()) {
                        int[] now = queue.poll();
                        int nowR = now[0];
                        int nowC = now[1];

                        for (int idx = 0; idx < 4; idx++) {
                            int nextR = nowR + dr[idx];
                            int nextC = nowC + dc[idx];

                            if (outOfCheese(nextR, nextC) || visited[nextR][nextC]) continue;
                            if (cheese[nextR][nextC] <= i) continue;
                            queue.add(new int[] {nextR, nextC});
                            visited[nextR][nextC] = true;
                        }
                    }
                }
            }
            maxCount = Math.max(maxCount, count);
        }


        System.out.println(maxCount);
	}
	
	public static boolean outOfCheese(int r, int c) {
		int n = cheese.length;
		return !(r >= 0 && r < n && c >= 0 && c < n);
	}
}
