import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
         
        int N = sc.nextInt();
        int P = sc.nextInt();
        int count = 0;
        
        Stack[] stacks = new Stack[N+1];
        
        for (int i = 0; i < N + 1; i++) {
        	stacks[i] = new Stack<Integer>();
        }
        
        for (int i = 0; i < N; i++) {
        	int stringNum = sc.nextInt();
        	int flat = sc.nextInt();
        	
        	Stack<Integer> stack = stacks[stringNum];
        	if (stack.isEmpty()) {
        		stack.push(flat);
        		count++;
        	} else {
        		while (!stack.isEmpty() && flat < stack.peek()) {
        			stack.pop();
        			count++;
        		}
        		if (stack.isEmpty() || flat != stack.peek()) {
        			stack.push(flat);
        			count++;
        		}
        	}
        }
        
        System.out.println(count);
    }
}