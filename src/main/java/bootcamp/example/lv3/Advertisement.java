package bootcamp.example.lv3;

public class Advertisement {
    public static void main(String[] args) {
        String play_time1 = "02:03:55";
        String adv_time1 = "00:14:15";
        String[] logs1 = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        String play_time2 = "99:59:59";
        String adv_time2 = "25:00:00";
        String[] logs2 = {"69:59:59-89:59:59", "01:00:00-21:00:00", "79:59:59-99:59:59", "11:00:00-31:00:00"};

        String play_time3 = "50:00:00";
        String adv_time3 = "50:00:00";
        String[] logs3 = {"15:36:51-38:21:49", "10:14:18-15:36:51", "38:21:49-42:51:45"};

        String play_time4 = "01:10:00";
        String adv_time4 = "01:00:00";
        String[] logs4 = {"00:30:00-00:45:00", "00:35:00-00:40:00", "00:40:00-00:45:00"};

        System.out.println(solution(play_time1, adv_time1, logs1));
        System.out.println(solution(play_time2, adv_time2, logs2));
        System.out.println(solution(play_time3, adv_time3, logs3));
        System.out.println(solution(play_time4, adv_time4, logs4));
    }

    // 프로그래머스 lv.3 광고 삽입
    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int playSec = convertToSec(play_time);
        int advSec = convertToSec(adv_time);
        long[] videoTime = new long[playSec + 1];

        for (int i = 0; i < logs.length; i++) {
            int startLog = convertToSec(logs[i].substring(0, 8));
            int endLog = convertToSec(logs[i].substring(9));
            videoTime[startLog] += 1;
            videoTime[endLog] -= 1;
        }

        for (int i = 1; i <= playSec; i++) {
            videoTime[i] += videoTime[i - 1];
        }
        for (int i = 1; i <= playSec; i++) {
            videoTime[i] += videoTime[i - 1];
        }

        int advStart = 0;
        long maxSum = 0;
        for (int i = 0; i <= playSec - advSec; i++) {
            int start = i;
            int end = i + advSec;
            long sum = videoTime[end - 1];
            if (i > 0) sum -= videoTime[start - 1];
            if (sum > maxSum) {
                maxSum = sum;
                advStart = start;
            }
        }
        answer = convertSecToString(advStart);
        return answer;
    }

    static int convertToSec(String time) {
        String[] split = time.split(":");
        int sec = 0;
        for (int i = 0; i < split.length; i++) {
            sec += Integer.parseInt(split[i]) * Math.pow(60, 2 - i);
        }
        return sec;
    }

    static String convertSecToString(int seconds) {
        int hour = seconds / 3600;
        int minute = seconds % 3600 / 60;
        int second = seconds % 3600 % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}
