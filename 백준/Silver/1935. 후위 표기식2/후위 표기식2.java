import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {
	public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        Map<Character, Integer> priority = new HashMap<>();
        
        priority.put('+', 1);
        priority.put('-', 1);
        priority.put('*', 2);
        priority.put('/', 2);
        priority.put('(', 0);
         
        int N = Integer.parseInt(br.readLine());
        // 입력받는 후위표기식
        String postfix = br.readLine();
        // 후위표기식으로 바꾸기 위한 Stack
        Stack<Double> stack = new Stack<>();
        double[] numbers = new double[N];
        
        for (int i = 0; i < N; i++) {
        	numbers[i] = Double.parseDouble(br.readLine());
        }
        
        for (int i = 0; i < postfix.length(); i++) {
        	// 중위표기식 중 i번째 토큰
        	char c = postfix.charAt(i);
        	
        	if ('A' <= c && c <= 'Z') { // 숫자일 때
        		stack.push(numbers[(c - 'A')]);
        	} else {
        		double num2 = stack.pop();
        		double num1 = stack.pop();
        		double temp = 0.0;
        		
        		if (c == '*') {
 					temp = num1 * num2;
 				} else if (c == '/') {
 					temp = num1 / num2;
 				} else if (c == '-') {
 					temp = num1 - num2;
 				} else {
 					temp = num1 + num2;
 				}
 				// stack에 temp 값 push하여 저장
 				stack.push(temp);
        	}
        }


        System.out.printf("%.2f", stack.pop());
    }
}