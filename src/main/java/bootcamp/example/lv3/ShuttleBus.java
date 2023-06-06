package bootcamp.example.lv3;

import java.util.Arrays;
import java.util.Stack;

public class ShuttleBus {
    public static void main(String[] args) {
        int n1 = 1;
        int t1 = 1;
        int m1 = 5;
        String[] timetable1 = {"08:00", "08:01", "08:02", "08:03"};

        int n2 = 2;
        int t2 = 10;
        int m2 = 2;
        String[] timetable2 = {"09:10", "09:09", "08:00"};

        int n3 = 2;
        int t3 = 1;
        int m3 = 2;
        String[] timetable3 = {"09:00", "09:00", "09:00", "09:00"};

        int n4 = 1;
        int t4 = 1;
        int m4 = 5;
        String[] timetable4 = {"00:01", "00:01", "00:01", "00:01", "00:01"};

        int n5 = 1;
        int t5 = 1;
        int m5 = 1;
        String[] timetable5 = {"23:59"};

        int n6 = 10;
        int t6 = 60;
        int m6 = 45;
        String[] timetable6 = {"23:59","23:59", "23:59", "23:59", "23:59",
            "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
            "23:59", "23:59", "23:59", "23:59"};

        System.out.println(solution(n1, t1, m1, timetable1));
        System.out.println(solution(n2, t2, m2, timetable2));
        System.out.println(solution(n3, t3, m3, timetable3));
        System.out.println(solution(n4, t4, m4, timetable4));
        System.out.println(solution(n5, t5, m5, timetable5));
        System.out.println(solution(n6, t6, m6, timetable6));
    }

    // 프로그래머스 lv.3 셔틀버스
    public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int[] crews = new int[timetable.length];
        int[] buses = new int[n];
        Stack<Integer> able = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        int last = 0;

        Arrays.sort(timetable);
        for (int i = 0; i < timetable.length; i++) {
            String[] split = timetable[i].split(":");
            crews[i] = Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
        }
        for (int i = 0; i < n; i++) {
            buses[i] = 9 * 60 + (t * i);
            while (stack.size() < m) {
                if (idx < crews.length && crews[idx] <= buses[i]) {
                    stack.push(crews[idx]);
                    idx++;
                } else {
                    break;
                }
            }
            if (stack.size() < m) {
                able.add(buses[i]);
            } else {
                able.add(stack.peek() - 1);
            }
            stack.clear();
        }
        last = able.pop();
        answer += (last / 60) < 10 ? "0" + (last / 60) : (last / 60);
        answer += ":";
        answer += (last % 60) < 10 ? "0" + (last % 60) : (last % 60);
        return answer;
    }
}
