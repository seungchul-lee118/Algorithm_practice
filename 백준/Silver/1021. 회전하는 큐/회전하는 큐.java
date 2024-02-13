import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	LinkedList<Integer> queue = new LinkedList<>();
    	
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int count = 0;
    	
    	for (int i = 1; i <= N; i++) {
    		queue.addLast(i);
    	}
    	
    	for (int i = 0; i < M; i++) {
    		int target = sc.nextInt();
    		if (target == queue.peek()) {
    			queue.poll();
    		} else {
    			if (queue.indexOf(target) <= queue.size() / 2) {
    				while (target != queue.peek()) {
    					queue.addLast(queue.pollFirst());
    					count++;
    				}
    				queue.poll();
    			} else {
    				while (target != queue.peek()) {
    					queue.addFirst(queue.pollLast());
    					count++;
    				}
    				queue.poll();
    			}
    		}
        }
    	System.out.println(count);
    }
}