package bootcamp.example.lv2;

import java.util.*;

public class Distance {
    public static void main(String[] args) {
        String[][] places = {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
            {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}};

        System.out.println(Arrays.toString(solution(places)));
    }

    // 프로그래머스 lv.2 거리두기 확인하기

    public static int[] solution(String[][] places) {
        int[] answer = new int[5];
        boolean[] blocked = new boolean[5];

        for (int i = 0; i < places.length; i++) {
            String[] place = places[i];
            for (int j = 0; j < place.length; j++) {
                for (int k = 0; k < place[0].length(); k++) {
                    if (place[j].charAt(k) != 'X') {
                        blocked[i] |= checkPerson(place, j, k);
                    }
                }
            }
            answer[i] = blocked[i] ? 0 : 1;
        }
        return answer;
    }

    public static boolean checkPerson(String[] place, int i, int j) {
        int count = 0;
        if (i - 1 >= 0) {
            count += place[i - 1].charAt(j) == 'P' ? 1 : 0;
        }
        if (j - 1 >= 0) {
            count += place[i].charAt(j - 1) == 'P' ? 1 : 0;
        }
        if (i + 1 < 5) {
            count += place[i + 1].charAt(j) == 'P' ? 1 : 0;
        }
        if (j + 1 < 5) {
            count += place[i].charAt(j + 1) == 'P' ? 1 : 0;
        }
        count += place[i].charAt(j) == 'P' ? 1 : 0;
        return count >= 2;
    }
}
