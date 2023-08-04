package bootcamp.example.PCCP;

public class Athletic {
    public static void main(String[] args) {
        int[][] ability1 = {{40, 10, 10}, {20, 5, 0}, {30, 30, 30}, {70, 0, 70}, {100, 100, 100}};
        int[][] ability2 = {{20, 30}, {30, 20}, {20, 30}};

        System.out.println(solution(ability1)); //210
        System.out.println(solution(ability2)); //60
    }

    // 프로그래머스 PCCP 모의고사 #1 체육대회

    public static int solution(int[][] ability) {
        return dfs(0, new boolean[ability.length], ability);
    }

    public static int dfs(int sport, boolean[] selected, int[][] ability) {
        if (sport == ability[0].length) {
            return 0;
        }
        int score = 0;
        for (int i = 0; i < ability.length; i++) {
            if (selected[i]) continue;
            selected[i] = true;
            score = Math.max(score, ability[i][sport] + dfs(sport + 1, selected, ability));
            selected[i] = false;
        }
        return score;
    }
}
