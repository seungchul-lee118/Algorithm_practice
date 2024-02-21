import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int M;
	static int N;
	static int H;
	static int[] dr = {-1, 0, 1, 0, 0, 0};
	static int[] dc = {0, 1, 0, -1, 0, 0};
	static int[] dz = {0, 0, 0, 0, 1, -1};
	public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
    	M = sc.nextInt();
    	N = sc.nextInt();
    	H = sc.nextInt();
    	int[][][] map = new int[H][N][M];
    	
    	for (int z = 0; z < H; z++) {
    		for (int r = 0; r < N; r++) {
    			for (int c = 0; c < M; c++) {
    				map[z][r][c] = sc.nextInt();
    			}
    		}
    	}
    	
    	BFS(map, new boolean[H][N][M]);
    }
	
	static void BFS(int[][][] map, boolean[][][] isVisited) {
    	Queue<int[]> queue = new LinkedList<>();
    	
    	for (int z = 0; z < H; z++) {
    		for (int r = 0; r < N; r++) {
    			for (int c = 0; c < M; c++) {
    				if (map[z][r][c] != 1) continue;
    				
    				queue.add(new int[] {z, r, c});
    				map[z][r][c] = 1;
    				isVisited[z][r][c] = true;
    			}
    		}
    	}
    	while(!queue.isEmpty()) {
    		int[] arr = queue.poll();
    		for (int i = 0; i < 6; i++) {
    			int nextZ = arr[0] + dz[i];
    			int nextR = arr[1] + dr[i];
    			int nextC = arr[2] + dc[i];
    			if (inMap(nextZ, nextR, nextC) && !isVisited[nextZ][nextR][nextC] && map[nextZ][nextR][nextC] == 0) {
    				queue.offer(new int[] {nextZ, nextR, nextC});
    				map[nextZ][nextR][nextC] = map[arr[0]][arr[1]][arr[2]] + 1;
    				isVisited[nextZ][nextR][nextC] = true;
    			}
    		}
    	}
    	boolean isOk = true;
    	int days = 1;
    	
    	loop:
    		for (int z = 0; z < H; z++) {
    			for (int r = 0; r < N; r++) {
    				for (int c = 0; c < M; c++) {
    					if (map[z][r][c] == 0) {
    						isOk = false;
    						break loop;
    					}
    					days = Math.max(days, map[z][r][c]);
    				}
    			}    			
    		}
    	System.out.println(isOk ? days - 1 : -1);
	}
	
	static boolean inMap(int nextZ, int nextR, int nextC) {
		return nextZ >= 0 && nextZ < H && nextR >= 0 && nextR < N && nextC >= 0 && nextC < M;
	}
}
