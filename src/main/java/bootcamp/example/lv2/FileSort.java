package bootcamp.example.lv2;

import java.util.Arrays;

public class FileSort {
    public static void main(String[] args) {
        String[] files1 = {"foo010bar020.zip"};
        String[] files2 = {"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
        String[] files3 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"};

        System.out.println(Arrays.toString(solution(files1)));
        System.out.println(Arrays.toString(solution(files2)));
        System.out.println(Arrays.toString(solution(files3)));
    }

    // 프로그래머스 lv.2 파일명 정렬

    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        String[][] result = new String[files.length][3];

        for (int i = 0; i < files.length; i++) {
            String example = files[i];
            int numStart = 0;
            int tailStart = 0;
            for (int j = 0; j < example.length(); j++) {
                if (example.charAt(j) >= '0' && example.charAt(j) <= '9') {
                    if (numStart == 0) {
                        numStart = j;
                    }
                } else {
                    if (numStart != 0) {
                        tailStart = j;
                        break;
                    }
                }
            }
            String head = example.substring(0, numStart);
            String number = tailStart == 0 ? example.substring(numStart) : example.substring(numStart, tailStart);
            result[i][0] = String.valueOf(i);
            result[i][1] = head;
            result[i][2] = number;
        }

        Arrays.sort(result, (o1, o2) -> {
            if (o1[1].equalsIgnoreCase(o2[1])) {
                if (Integer.parseInt(o1[2]) == Integer.parseInt(o2[2])) {
                    return Integer.parseInt(o1[0]) - Integer.parseInt(o2[0]);
                }
                return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
            }
            return o1[1].compareToIgnoreCase(o2[1]);
        });

        for (int i = 0; i < files.length; i++) {
            int idx = Integer.parseInt(result[i][0]);
            answer[i] = files[idx];
        }
        return answer;
    }
}
