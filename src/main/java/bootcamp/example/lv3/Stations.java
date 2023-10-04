package bootcamp.example.lv3;

public class Stations {
    public static void main(String[] args) {
        int n1 = 11;
        int[] stations1 = {4, 11};
        int w1 = 1;

        int n2 = 16;
        int[] stations2 = {9};
        int w2 = 2;

        System.out.println(solution(n1, stations1, w1));
        System.out.println(solution(n2, stations2, w2));
    }

    // 프로그래머스 Lv.3 기지국 설치

    public static int solution(int n, int[] stations, int w) {
        int answer = 0;
        int unitWidth = 2 * w + 1;
        int start = 1;
        int end;
        for (int station : stations) {
            end = station - w;
            int blankWidth = end - start;
            if (blankWidth > 0) {
                answer += blankWidth % unitWidth == 0 ? blankWidth / unitWidth : blankWidth / unitWidth + 1;
            }
            start = station + w + 1;
        }
        if (start <= n) {
            end = n + 1;
            int blankWidth = end - start;
            answer += blankWidth % unitWidth == 0 ? blankWidth / unitWidth : blankWidth / unitWidth + 1;
        }
        return answer;
    }
}