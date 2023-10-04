package bootcamp.example.lv3;

import java.util.Arrays;
import java.util.Comparator;

public class Camera {
    public static void main(String[] args) {
        int[][] routes = {{-20, -15}, {-14, -5}, {-18, -13}, {-5, -3}};

        System.out.println(solution(routes));
    }

    // 프로그래머스 Lv.3 단속카메라

    public static int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, Comparator.comparingInt(o -> o[1]));
        int lastCamera = -30001;
        for (int[] route : routes) {
            if (route[0] > lastCamera) {
                lastCamera = route[1];
                answer++;
            }
        }
        return answer;
    }
}