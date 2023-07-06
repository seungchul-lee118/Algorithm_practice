package bootcamp.example.lv2;

public class TransformBracket {
    public static void main(String[] args) {
        String p1 = "(()())()";
        String p2 = ")(";
        String p3 = "()))((()";

        System.out.println(solution(p1));
        System.out.println(solution(p2));
        System.out.println(solution(p3));
    }

    // 프로그래머스 lv.2 괄호 변환

    public static String solution(String p) {
        String answer = "";
        String u = "";
        String v = "";
        int count = 0;
        if (p.length() == 0) return "";

        for (int i = 0; i < p.length(); i++) {
            count = p.charAt(i) == '(' ? count + 1 : count - 1;
            if (count == 0) {
                u = p.substring(0, i + 1);
                v = p.substring(i + 1);
                break;
            }
        }

        if (correctString(u)) {
            answer += u + solution(v);
        } else {
            StringBuilder builder = new StringBuilder();
            builder.append("(")
                .append(solution(v))
                .append(")");
            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(') {
                    builder.append(")");
                } else {
                    builder.append("(");
                }
            }
            answer += builder;
        }

        return answer;
    }

    public static boolean correctString(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count = s.charAt(i) == '(' ? count + 1 : count - 1;
            if (count < 0) {
                return false;
            }
        }
        return true;
    }
}
