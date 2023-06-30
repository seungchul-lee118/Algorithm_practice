package bootcamp.example.lv2;

import java.util.*;

public class RecentMusic {
    public static void main(String[] args) {
        String m1 = "ABCDEFG";
        String[] musicinfos1 = {"12:00,12:14,HELLO,CDEFGAB",
            "13:00,13:05,WORLD,ABCDEF"};
        String m2 = "CC#BCC#BCC#BCC#B";
        String[] musicinfos2 = {"03:00,03:30,FOO,CC#B",
            "04:00,04:08,BAR,CC#BCC#BCC#B"};
        String m3 = "ABC";
        String[] musicinfos3 = {"12:00,12:14,HELLO,C#DEFGAB",
            "13:00,13:05,WORLD,ABCDEF"};

        System.out.println(solution(m1, musicinfos1));
        System.out.println(solution(m2, musicinfos2));
        System.out.println(solution(m3, musicinfos3));
    }

    // 프로그래머스 lv.2 방금그곡

    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        int maxPlayTime = 0;
        m = getReplace(m);

        for (int i = 0; i < musicinfos.length; i++) {
            String[] array = getReplace(musicinfos[i]).split(",");
            String sheet = array[3];
            StringBuilder actualPlay = new StringBuilder();
            int playTime = playTime(array);

            for (int j = 0; j < playTime; j++) {
                char c = sheet.charAt(j % sheet.length());
                actualPlay.append(c);
            }
            if (actualPlay.toString().contains(m) && playTime > maxPlayTime) {
                maxPlayTime = playTime;
                answer = array[2];
            }
        }

        return answer;
    }

    public static String getReplace(String m) {
        return m.replace("C#", "c")
            .replace("D#", "d")
            .replace("F#", "f")
            .replace("A#", "a")
            .replace("G#", "g");
    }

    public static int playTime(String[] splitArray) {
        String[] start = splitArray[0].split(":");
        String[] end = splitArray[1].split(":");
        int hour = Integer.parseInt(end[0]) - Integer.parseInt(start[0]);
        int minute = Integer.parseInt(end[1]) - Integer.parseInt(start[1]);
        return hour * 60 + minute;
    }
}
