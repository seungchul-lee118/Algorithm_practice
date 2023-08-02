package bootcamp.example.lv1;

public class XSpaceNNumber {
    public static void main(String[] args) {

    }

    // 프로그래머스 lv.1 x만큼 간격이 있는 n개의 숫자

    public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        for (int i = 0; i < n; i++) {
            answer[i] = (long)(i + 1) * x;
        }
        return answer;
    }
}
