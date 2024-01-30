import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		StringBuilder sb = new StringBuilder();
		
		for (int n = 0; n < N; n++) {
			String command = sc.next();
			if (command.equals("push")) {		
				stack.push(sc.nextInt());
			} else if (command.equals("top")) {
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.peek()).append("\n");
				}
			} else if (command.equals("size")) {
				sb.append(stack.size()).append("\n");
			} else if (command.equals("pop")) {
				if (stack.isEmpty()) {
					sb.append(-1).append("\n");
				} else {
					sb.append(stack.pop()).append("\n");
				}
			} else if (command.equals("empty")) {
				if (stack.isEmpty()) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			}
		}
		System.out.println(sb);
	}
}