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
         
        // 입력받는 중위표기식
        String sentence = br.readLine();
        // 후위표기식으로 바꾸기 위한 Stack
        Stack<Character> stack = new Stack<>();

        // 후위표기식
        String postfix = "";
        
        for (int i = 0; i < sentence.length(); i++) {
        	// 중위표기식 중 i번째 토큰
        	char c = sentence.charAt(i);
        	
        	// c가 열린 괄호일 때
        	if (c == '(') {
        		// stack에 push
        		stack.push(c);
        	} else if (c == ')') { // 닫힌 괄호일 때
        		// 열린괄호가 나올 때까지 pop 해서 후취표기식에 추가
        		while(stack.peek() != '(') {
        			postfix += stack.pop();
        		}
        		// 열린괄호 pop
        		stack.pop();
        	} else if ('A' <= c && c <= 'Z') { // 숫자일 때
        		postfix += c;
        	} else {
        		// 연산자일 때
        		// stack이 비어있다면
        		if (stack.isEmpty()) {
        			// stack에 추가
        			stack.push(c);
        		} else {
        			// 비어있지 않고, stack의 가장 위에 있는 연산자의 우선순위가 현재 연산자의 우선순위보다 클 경우
        			// 현재 연산자의 우선순위가 더 커질 때까지 pop 해서 후휘표기식에 추가
        			while (!stack.isEmpty() && priority.get(c) <= priority.get(stack.peek())) {
        				postfix += stack.pop();
        			}
        			// 현재 연산자 stack에 추가
        			stack.push(c); 
        		}
        	}
        }
        // + 연산자의 경우 우선순위가 가장 낮아 pop 되지 못하므로 stack에 남아있는 연산자 추가
        while (!stack.isEmpty()) {
        	postfix += stack.pop();
        }
        
        System.out.println(postfix);
    }
}