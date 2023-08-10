package bootcamp.example.lv2;

public class NormalRectangle {
    public static void main(String[] args) {
        int w = 8;
        int h = 12;

        int w1 = 3;
        int h1 = 3;

        System.out.println(solution(w, h)); //80
        System.out.println(solution(w1, h1));
    }

    // 프로그래머스 lv.2 멀쩡한 사각형

    public static long solution(int w, int h) {
        long answer = 0;
        long unit = 0;
        int gcd = gcd(w, h);
        unit = w/gcd + h/gcd - 1;
        answer = (long) w * h - unit * gcd;
        return answer;
    }

    public static int gcd(int w, int h) {
        return w % h == 0 ? h : gcd(h, w % h);
    }
}
