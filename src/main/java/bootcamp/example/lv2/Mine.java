package bootcamp.example.lv2;

import java.util.*;

public class Mine {
    public static void main(String[] args) {
        int[] picks1 = {1, 3, 2};
        String[] minerals1 = {"diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"};

        int[] picks2 = {0, 1, 1};
        String[] minerals2 = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        System.out.println(solution(picks1, minerals1));
        System.out.println(solution(picks2, minerals2));
    }

    // 프로그래머스 lv.2 광물 캐기

    public static int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int[] counts = new int[picks.length];
        Map<Integer, int[]> pickMap = new HashMap<>();
        pickMap.put(0, new int[]{1, 1, 1});
        pickMap.put(1, new int[]{5, 1, 1});
        pickMap.put(2, new int[]{25, 5, 1});

        int pickSum = Arrays.stream(picks).sum();
        int length = Math.min(pickSum * 5, minerals.length);
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            String mineral = minerals[i];
            if (mineral.equals("diamond")) {
                counts[0]++;
            } else if (mineral.equals("iron")) {
                counts[1]++;
            } else {
                counts[2]++;
            }
            if ((i + 1) % 5 == 0 || i == length - 1) {
                list.add(Arrays.copyOf(counts, counts.length));
                Arrays.fill(counts, 0);
            }
        }

        list.sort((o1, o2) -> {
            if (o1[0] == o2[0]) {
                if (o1[1] == o2[1]) return o2[2] - o1[2];
                return o2[1] - o1[1];
            }
            return o2[0] - o1[0];
        });

        int idx = 0;
        for (int i = 0; i < picks.length; i++) {
            while (picks[i] > 0 && idx < list.size()) {
                int[] fatigue = pickMap.get(i);
                for (int j = 0; j < 3; j++) {
                    answer += list.get(idx)[j] * fatigue[j];
                }
                picks[i]--;
                idx++;
            }
        }

        return answer;
    }
}
