package bootcamp.example.lv3;

import java.util.*;

public class JewelShopping {
    public static void main(String[] args) {
        String[] gems1 = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        String[] gems2 = {"AA", "AB", "AC", "AA", "AC"};
        String[] gems3 = {"XYZ", "XYZ", "XYZ"};
        String[] gems4 = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};

        System.out.println(Arrays.toString(solution(gems1)));
        System.out.println(Arrays.toString(solution(gems2)));
        System.out.println(Arrays.toString(solution(gems3)));
        System.out.println(Arrays.toString(solution(gems4)));
    }

    // 프로그래머스 Lv.3 보석 쇼핑

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];
        int startIdx = 0;
        int endIdx = 0;
        int minLength = 100001;
        Map<String, Integer> gemMap = new HashMap<>();
        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }
        int gemTypesNum = gemSet.size();

        for (int i = 0; i < gems.length; i++) {
            gemMap.put(gems[i], gemMap.getOrDefault(gems[i], 0) + 1);
            while (gemMap.get(gems[startIdx]) > 1) {
                Integer gemCount = gemMap.get(gems[startIdx]);
                gemMap.put(gems[startIdx], gemCount - 1);
                startIdx++;
            }
            if (gemMap.size() == gemTypesNum && (i - startIdx + 1) < minLength) {
                minLength = i - startIdx + 1;
                endIdx = i;
                answer = new int[]{startIdx + 1, endIdx + 1};
            }
        }
        return answer;
    }

}