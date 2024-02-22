import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int M;
	static int N;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
    	M = sc.nextInt();
    	N = sc.nextInt();
    	int[][] map = new int[N][M];
    	
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
    	
    	BFS(map, new boolean[N][M]);
    }
	
	static void BFS(int[][] map, boolean[][] isVisited) {
    	Queue<int[]> queue = new LinkedList<>();
    	
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] != 1) continue;
				
				queue.add(new int[] {r, c});
				map[r][c] = 1;
				isVisited[r][c] = true;
			}
		}
    	while(!queue.isEmpty()) {
    		int[] arr = queue.poll();
    		for (int i = 0; i < 4; i++) {
    			int nextR = arr[0] + dr[i];
    			int nextC = arr[1] + dc[i];
    			if (inMap(nextR, nextC) && !isVisited[nextR][nextC] && map[nextR][nextC] == 0) {
    				queue.offer(new int[] {nextR, nextC});
    				map[nextR][nextC] = map[arr[0]][arr[1]] + 1;
    				isVisited[nextR][nextC] = true;
    			}
    		}
    	}
    	boolean isOk = true;
    	int days = 1;
    	
    	loop:
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (map[r][c] == 0) {
					isOk = false;
					break loop;
				}
				days = Math.max(days, map[r][c]);
			}
		}    			
    	System.out.println(isOk ? days - 1 : -1);
	}
	
	static boolean inMap(int nextR, int nextC) {
		return nextR >= 0 && nextR < N && nextC >= 0 && nextC < M;
	}
}