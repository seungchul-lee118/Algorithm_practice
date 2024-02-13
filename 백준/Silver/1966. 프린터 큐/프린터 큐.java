import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
        	PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        	Queue<int[]> queue = new LinkedList<>();
        	
        	int N = sc.nextInt();
        	int idx = sc.nextInt();
        	
        	for (int i = 0; i < N; i++) {
        		int num = sc.nextInt();
        		pq.offer(num);
        		queue.offer(new int[] {num, i});
        	}
        	
        	for (int i = 0; i < N; i++) {
        		while (pq.peek() != queue.peek()[0]) {
        			queue.offer(queue.poll());
        		}
        		pq.poll();
        		if (queue.poll()[1] == idx) {
        			System.out.println(i + 1);
        			break;
        		}
        	}
        	
        	
        }
    }
}