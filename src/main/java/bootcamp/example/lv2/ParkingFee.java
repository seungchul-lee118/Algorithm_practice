package bootcamp.example.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ParkingFee {
    public static void main(String[] args) {
        int[] fees1 = {180, 5000, 10, 600};
        String[] records1 = {"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT",
            "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT",
            "22:59 5961 IN", "23:00 5961 OUT"};

        int[] fees2 = {120, 0, 60, 591};
        String[] records2 = {"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT",
            "18:00 0202 OUT","23:58 3961 IN"};

        int[] fees3 = {1, 461, 1, 10};
        String[] records3 = {"00:00 1234 IN"};

        int[] fees4 = {180, 5000, 10, 1000};
        String[] records4 =  {"05:59 0000 IN", "05:59 1111 IN"};

        System.out.println(Arrays.toString(solution(fees1, records1)));
        System.out.println(Arrays.toString(solution(fees2, records2)));
        System.out.println(Arrays.toString(solution(fees3, records3)));
        System.out.println(Arrays.toString(solution(fees4, records4)));
    }

    // 프로그래머스 lv.2 주차 요금 계산

    public static int[] solution(int[] fees, String[] records) {
        List<Integer> result = new ArrayList<>();

        Arrays.sort(records, Comparator.comparing(o -> o.split(" ")[1]));
        String carNum = records[0].split(" ")[1];
        int totalTime = 0;
        int inTime = 0;
        int outTime = 0;
        boolean isIn = false;

        for (int i = 0; i < records.length; i++) {
            String[] split = records[i].split(" ");
            String[] time = split[0].split(":");
            if (!carNum.equals(split[1])) {
                carNum = split[1];

                getTotalFee(result, fees, totalTime, inTime, outTime, isIn);
                totalTime = 0;
                isIn = false;
            }

            if (split[2].equals("IN")) {
                inTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                isIn = true;
            } else {
                outTime = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
                totalTime += (outTime - inTime);
                isIn = false;
            }
        }
        getTotalFee(result, fees, totalTime, inTime, outTime, isIn);

        int[] answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void getTotalFee(List<Integer> result, int[] fees, int totalTime, int inTime, int outTime, boolean isIn) {
        int basicTime = fees[0];
        int basicFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];
        int totalFee = basicFee;

        if (isIn) {
            totalTime += 1439 - inTime;
        }
        if (totalTime > basicTime) {
            totalFee += (int)Math.ceil((double) (totalTime - basicTime) / unitTime) * unitFee;
        }
        result.add(totalFee);
    }
}
