import java.util.Scanner;
import java.util.Stack;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int K = sc.nextInt();
		Stack<Integer> stack = new Stack<>();
		int result = 0;
		
		for (int n = 0; n < K; n++) {
			int num = sc.nextInt();
			if (num == 0) {
				stack.pop();
			} else {
				stack.push(num);
			}
		}
		
		for (Integer integer : stack) {
			result += integer;
		}
		
		System.out.println(result);
	}
}