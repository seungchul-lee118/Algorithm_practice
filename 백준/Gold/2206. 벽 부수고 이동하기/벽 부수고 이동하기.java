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
        
    	N = sc.nextInt();
    	M = sc.nextInt();
    	int[][] map = new int[N][M];
    	
		for (int r = 0; r < N; r++) {
			String[] split = sc.next().split("");
			for (int c= 0; c < split.length; c++) {
				map[r][c] = Integer.parseInt(split[c]);
			}
		}
    	
    	BFS(map, new boolean[2][N][M]);
    }
	
	static void BFS(int[][] map, boolean[][][] isVisited) {
    	Queue<int[]> queue = new LinkedList<>();
    	int result = 0;
    	
		queue.add(new int[] {0, 0, 0, 1});
		isVisited[0][0][0] = true;
		
		while(!queue.isEmpty()) {
			int[] arr = queue.poll();
			if (arr[0] == N - 1 && arr[1] == M - 1) {
                result = arr[3];
                break;
            }
			for (int i = 0; i < 4; i++) {
				int nextR = arr[0] + dr[i];
				int nextC = arr[1] + dc[i];
				if (!inMap(nextR, nextC)) continue;
				
				if (map[nextR][nextC] == 0) {
					if (!isVisited[arr[2]][nextR][nextC]) {
						queue.offer(new int[] {nextR, nextC, arr[2], arr[3] + 1});
						isVisited[arr[2]][nextR][nextC] = true;
					}
				}
				if(map[nextR][nextC] == 1 && arr[2] == 0 && !isVisited[1][nextR][nextC]) {
					queue.offer(new int[] {nextR, nextC, arr[2] + 1, arr[3] + 1});									
					isVisited[arr[2]+1][nextR][nextC] = true;
				}
			}
		}	
    	System.out.println(result == 0 ? -1 : result);
	}
	
	static boolean inMap(int nextR, int nextC) {
		return nextR >= 0 && nextR < N && nextC >= 0 && nextC < M;
	}
}
