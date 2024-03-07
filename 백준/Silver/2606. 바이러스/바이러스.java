import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
     
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        int[][] computers = new int[N][N];
        int count = 0;
        boolean[] visited = new boolean[N];
        Queue<Integer> queue = new LinkedList<>();
        
        for (int i = 0; i < M; i++) {
        	int com1 = sc.nextInt() - 1;
        	int com2 = sc.nextInt() - 1;
        	computers[com1][com2] = 1;
        	computers[com2][com1] = 1;
        }
        
        queue.add(0);
        visited[0] = true;
        
        while(!queue.isEmpty()) {
        	int now = queue.poll();
        	
        	for (int i = 0; i < N; i++) {
        		if (visited[i] || computers[now][i] == 0) continue;
        		queue.offer(i);
        		visited[i] = true;
        		count++;
        	}
        }
        
        System.out.println(count);
    }
}