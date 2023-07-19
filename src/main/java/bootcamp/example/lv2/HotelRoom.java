package bootcamp.example.lv2;

import java.time.LocalTime;
import java.util.*;

public class HotelRoom {
    public static void main(String[] args) {
        String[][] bookTime1 = {{"15:00", "17:00"},
            {"16:40", "18:20"}, {"14:20", "15:20"},
            {"14:10", "19:20"}, {"18:20", "21:20"}};
        String[][] bookTime2 = {{"09:10", "10:10"}, {"10:20", "12:20"}};
        String[][] bookTime3 = {{"10:20", "12:30"}, {"10:20", "12:30"},
            {"10:20", "12:30"}};
        String[][] bookTime4 = {{"05:57", "06:02"},
            {"04:00", "06:59"}, {"03:56", "07:57"},
            {"06:12", "08:55"}, {"07:09", "07:11"}};
        String[][] bookTime5 = {{"09:10", "10:10"},
            {"09:10", "10:10"}, {"10:20", "12:20"}, {"10:20", "12:20"}};
        String[][] bookTime6 = {{"23:40", "23:49"},
            {"23:41", "23:50"}, {"23:59", "00:08"}};

//        System.out.println(solution(bookTime1));
//        System.out.println(solution(bookTime2));
//        System.out.println(solution(bookTime3));
//        System.out.println(solution(bookTime4));
//        System.out.println(solution(bookTime5));
        System.out.println(solution(bookTime6));
    }

    // 프로그래머스 lv.2 호텔 대실

    public static int solution(String[][] book_time) {
        int answer = 0;
        PriorityQueue<LocalTime> queue = new PriorityQueue<>();
        Arrays.sort(book_time, Comparator.comparing(o -> LocalTime.parse(o[0])));

        for (String[] time : book_time) {
            LocalTime startTime = LocalTime.parse(time[0]);
            LocalTime endTime = LocalTime.parse(time[1]);
            if (!queue.isEmpty()) {
                if (!startTime.isBefore(queue.peek().plusMinutes(10))) {
                    queue.poll();
                }
            }
            queue.add(endTime);
        }

        answer = queue.size();
        return answer;
    }
}
