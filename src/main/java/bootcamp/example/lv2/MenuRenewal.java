package bootcamp.example.lv2;

import java.util.*;

public class MenuRenewal {
    public static void main(String[] args) {
        String[] orders1 = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course1 = {2, 3, 4};

        String[] orders2 = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course2 = {2, 3, 5};

        String[] orders3 = {"XYZ", "XWY", "WXA"};
        int[] course3 = {2, 3, 4};

        System.out.println(Arrays.toString(solution(orders1, course1)));
//        System.out.println(Arrays.toString(solution(orders2, course2)));
//        System.out.println(Arrays.toString(solution(orders3, course3)));
    }

    // 프로그래머스 lv.2 메뉴 리뉴얼

    public static String[] solution(String[] orders, int[] course) {
        List<String> list = new ArrayList<>();
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        int maxLength = course[course.length - 1];

        for (int i : course) {
            map.put(i, map.getOrDefault(i, new HashMap<>()));
            set.add(i);
        }

        for (String order : orders) {
            char[] split = order.toCharArray();
            Arrays.sort(split);
            dfs(new String(split), new StringBuilder(), 0, maxLength,
                new boolean[orders.length], map, set);
        }

        for (int length : course) {
            int max = 0;
            Map<String, Integer> temp = map.get(length);
            for (String key : temp.keySet()) {
                max = Math.max(max, temp.get(key));
            }

            if (max < 2) continue;
            for (String key : temp.keySet()) {
                if (temp.get(key) == max) {
                    list.add(key);
                }
            }
        }

        Collections.sort(list);
        return list.toArray(new String[0]);
    }

    private static void dfs(String s, StringBuilder builder, int idx, int maxLength,
                            boolean[] visited, Map<Integer, Map<String, Integer>> map, Set<Integer> set) {
        int len = builder.length();
        if (set.contains(len)){
            String comb = builder.toString();
            int cnt = map.get(len).getOrDefault(comb, 0) + 1;
            map.get(len).put(comb, cnt);
            if (builder.length() == maxLength) return;
        }

        for (int i = idx; i < s.length(); i ++){
            if (visited[i]) continue;
            builder.append(s.charAt(i));
            visited[i] = true;
            dfs(s, builder, i + 1, maxLength, visited, map, set);
            visited[i] = false;
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
