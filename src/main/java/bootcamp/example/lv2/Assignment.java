package bootcamp.example.lv2;

import java.util.*;

public class Assignment {
    public static void main(String[] args) {
        String[][] plans1 = {{"korean", "11:40", "30"}, {"english", "12:10", "20"}, {"math", "12:30", "40"}};
        String[][] plans2 = {{"science", "12:40", "50"},{"music", "12:20", "40"}, {"history", "14:00", "30"}, {"computer", "12:30", "100"}};
        String[][] plans3 = {{"aaa", "12:00", "20"},{"bbb", "12:10", "30"},{"ccc", "12:40", "10"}};

//        System.out.println(Arrays.toString(solution(plans1)));
//        System.out.println(Arrays.toString(solution(plans2)));
        System.out.println(Arrays.toString(solution(plans3)));
    }

    // 프로그래머스 lv.2 과제 진행하기

    public static String[] solution(String[][] plans) {
        List<String> result = new ArrayList<>();
        Stack<String[]> remains = new Stack<>();
        Arrays.sort(plans, Comparator.comparing(o -> o[1]));

        for (int i = 0; i < plans.length - 1; i++) {
            String nowAssignment = plans[i][0];
            int nowMinutes = getMinutes(plans[i][1]);
            int playtime = Integer.parseInt(plans[i][2]);
            int endMinutes = nowMinutes + playtime;

            int nextMinutes = getMinutes(plans[i + 1][1]);
            int freeMinute = nextMinutes - endMinutes;

            if (freeMinute < 0) {
                remains.push(new String[]{nowAssignment, String.valueOf(-freeMinute)});
            } else {
                result.add(nowAssignment);
                while (freeMinute > 0 && !remains.isEmpty()) {
                    String[] recentRemain = remains.pop();
                    int remainTime = Integer.parseInt(recentRemain[1]);
                    freeMinute -= remainTime;
                    if (freeMinute >= 0) {
                        result.add(recentRemain[0]);
                    } else {
                        remains.push(new String[]{recentRemain[0], String.valueOf(-freeMinute)});
                    }
                }
            }
        }

        result.add(plans[plans.length - 1][0]);
        while (!remains.isEmpty()) {
            result.add(remains.pop()[0]);
        }

        return result.toArray(new String[0]);
    }

    static int getMinutes(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }
}