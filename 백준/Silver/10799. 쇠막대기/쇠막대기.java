import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
 
public class Main
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 쇠막대기와 레이저의 배치 입력
        String[] sentence = br.readLine().split("");
        // 현재 쌓여있는 쇠막대기 수 확인 하기 위한 stack
        Stack<String> stack = new Stack<>();
        // 레이저에 의해 잘려진 조각의 수
        int result = 0;

        // 입력받은 문자열 순회
        for (int i = 0; i < sentence.length; i++) {
            // 특정 idx의 문자
            String s = sentence[i];

            // 닫는 괄호일 때는 레이저 or 쇠막대기 끝
            if (s.equals(")")) {
                // 스택에 있는 여는 괄호 pop
                stack.pop();
                // 쇠막대기가 끝나는 것이 아닌 레이저일 때
                if (sentence[i-1].equals("(")) {
                    // 현재 있는 쇠막대기 수만큼 조각에 추가
                    result += stack.size();
                } else {
                    // 쇠막대기가 끝나는 것일 때 조각 수 + 1
                    result++;
                }
            } else {
                // 여는 괄호일 때, 쇠막대기 추가 혹은 레이저 stack에 추가
                stack.push(s);
            }
        }
        System.out.println(result);
    }
}