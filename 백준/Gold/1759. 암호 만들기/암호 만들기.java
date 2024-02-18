import java.util.*;

public class Main {
    static String[] vowels = {"a", "e", "i", "o", "u"};
    static int L;
    static int C;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        L = sc.nextInt();
        C = sc.nextInt();
        String[] alphabets = new String[C];

        for (int i = 0; i < C; i++) {
            alphabets[i] = sc.next();
        }
        Arrays.sort(alphabets);
        getCodes(0, alphabets, new StringBuilder());
    }

    static void getCodes(int depth, String[] alphabets, StringBuilder builder) {
        if (depth >= C || builder.length() == L) {
            if (builder.length() == L && isCorrect(builder)) {
                System.out.println(builder);
            }
        }
        for (int i = depth; i < C; i++) {
            if (builder.indexOf(alphabets[i]) != -1) {
                continue;
            }
            if (builder.length() == 0 || alphabets[i].compareTo(String.valueOf(builder.charAt(builder.length() - 1))) > 0) {
                builder.append(alphabets[i]);
                getCodes(depth + 1, alphabets, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }

    static boolean isCorrect(StringBuilder builder) {
        int count = 0;
        for (String vowel : vowels) {
            if (builder.indexOf(vowel) != -1) {
                count++;
            }
        }
        return count >= 1 && builder.length() - count >= 2;
    }
}