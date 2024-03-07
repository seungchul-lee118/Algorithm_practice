import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
     
        int N = sc.nextInt();
        
        ArrayList[] members = new ArrayList[N + 1];
        int[] depths = new int[N+1];
        int minDepth = 50;
        int count = 0;
        
        for (int i = 0; i < N + 1; i++) {
        	members[i] = new ArrayList<Integer>();
        }
        
        while(true) {
        	int num1 = sc.nextInt();
        	int num2 = sc.nextInt();
        	
        	if (num1 == -1 && num2 == -1) {
        		break;
        	}
        	
        	members[num1].add(num2);
        	members[num2].add(num1);
        }
        
        
        for (int idx = 1; idx <= N; idx++) {
        	boolean[] visited = new boolean[N + 1];
        	Queue<int[]> queue = new LinkedList<>();
        	int depth = 0;
        	
        	queue.offer(new int[] {idx, 0});
        	visited[idx] = true;
        	
        	while(!queue.isEmpty()) {
        		int[] now = queue.poll();
        		List<Integer> list = members[now[0]];
        		
        		for (Integer next : list) {
					if (visited[next]) continue;
					queue.offer(new int[] {next, now[1] + 1});
					visited[next] = true;
					depth = Math.max(depth, now[1] + 1);
				}
        	}
        	depths[idx] = depth;
        	minDepth = Math.min(minDepth, depth);
        }
        
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i<= N; i++) {
        	if (depths[i] == minDepth) {
        		count++;
        		builder.append(i).append(' ');
        	}
        }
        
        System.out.println(minDepth + " " + count);
        System.out.println(builder);
    }
}