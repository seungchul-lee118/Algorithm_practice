package bootcamp.example.lv3;

public class Scores {
    public static void main(String[] args) {
        int[][] scores = {{2, 2}, {1, 4}, {3, 2}, {3, 2}, {2, 1}};

        System.out.println(solution(scores));
    }

    // 프로그래머스 lv.3 인사고과
    public static int solution(int[][] scores) {
        int answer = 1;
        int[] target = scores[0];
        int sum = target[0] + target[1];
        if (!canGetBonus(target, scores)) return -1;
        for (int i = 1; i < scores.length; i++) {
            if (scores[i][0] + scores[i][1] > sum) {
                if (canGetBonus(scores[i], scores)) {
                    answer++;
                }
            }
        }
        return answer;
    }

    static boolean canGetBonus(int[] score, int[][] scores) {
        int attitude = score[0];
        int companion = score[1];
        for (int i = 0; i < scores.length; i++) {
            if (attitude < scores[i][0] && companion < scores[i][1]) return false;
        }
        return true;
    }
}
