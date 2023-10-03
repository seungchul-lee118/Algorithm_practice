package bootcamp.example.lv3;

public class TransWord {
    public static void main(String[] args) {
        String begin1 = "hit";
        String target1 = "cog";
        String[] words1 = {"hot", "dot", "dog", "lot", "log", "cog"};

        String begin2 = "hit";
        String target2 = "cog";
        String[] words2 = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(begin1, target1, words1));
        System.out.println(solution(begin2, target2, words2));
    }

    // 프로그래머스 lv.3 단어 변환
    public static int solution(String begin, String target, String[] words) {
        boolean trans = false;
        for (String word : words) {
            if (word.equals(target)) trans = true;
        }
        if (!trans) return 0;

        int[] answer = {1000};
        dfs(begin, target, new boolean[words.length], words, 0, answer);
        return answer[0];
    }

    static void dfs(String start, String target, boolean[] visited, String[] words, int count, int[] answer) {
        if (start.equals(target)) {
            answer[0] = Math.min(count, answer[0]);
            return;
        }
        for (int i = 0; i < words.length; i++) {
            if (start.equals(words[i]) || visited[i]) continue;
            if (canTrans(start, words[i])) {
                visited[i] = true;
                dfs(words[i], target, visited, words, count + 1, answer);
                visited[i] = false;
            }
        }
    }

    static boolean canTrans(String now, String target) {
        int count = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) == target.charAt(i)) {
                count++;
            }
        }
        return count == now.length() - 1;
    }
}
