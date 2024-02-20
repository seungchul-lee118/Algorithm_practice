import java.util.*;

public class Main {
	
	static int M;
	static int N;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, 1, 0, -1};
	public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for (int tc = 1; tc <= T; tc++) {
        	M = sc.nextInt();
        	N = sc.nextInt();
        	int[][] map = new int[N][M];
        	int K = sc.nextInt();
        	
        	for (int i = 0; i < K; i++) {
        		int x = sc.nextInt();
        		int y = sc.nextInt();
        		map[y][x] = 1;
        	}
        	
        	BFS(map, new boolean[N][M]);
        }
    }
	
	static void BFS(int[][] map, boolean[][] isVisited) {
		int count = 0;
    	Queue<int[]> queue = new LinkedList<>();
    	
    	
    	for (int y = 0; y < map.length; y++) {
    		for (int x = 0; x < map[0].length; x++) {
    			if (isVisited[y][x] || map[y][x] == 0) continue;
    			
    			queue.add(new int[] {y, x});
    			isVisited[y][x] = true;
    			count++;
    			while(!queue.isEmpty()) {
    				int[] arr = queue.poll();
    				for (int i = 0; i < 4; i++) {
    					int nextY = arr[0] + dy[i];
    					int nextX = arr[1] + dx[i];
    					if (inMap(nextY, nextX) && !isVisited[nextY][nextX] && map[nextY][nextX] == 1) {
    						queue.offer(new int[] {nextY, nextX});
    						isVisited[nextY][nextX] = true;
    					}
    				}
    			}
    		}
    	}
    	System.out.println(count);
	}
	
	static boolean inMap(int nextY, int nextX) {
		return nextY >= 0 && nextY < N && nextX >= 0 && nextX < M;
	}
}