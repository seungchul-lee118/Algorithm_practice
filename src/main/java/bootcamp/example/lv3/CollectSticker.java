package bootcamp.example.lv3;

public class CollectSticker {
    public static void main(String[] args) {
        int[] sticker1 = {14, 6, 5, 11, 3, 9, 2, 10};
        int[] sticker2 = {1, 3, 2, 5, 4};
        int[] sticker3 = {1, 3, 5, 4, 6};

        System.out.println(solution(sticker1));
        System.out.println(solution(sticker2));
        System.out.println(solution(sticker3));
    }

    // 프로그래머스 Lv.3 스티커 모으기(2)

    public static int solution(int[] sticker) {
        if (sticker.length == 1) return sticker[0];

        int[] dp1 = new int[sticker.length];
        int[] dp2 = new int[sticker.length];

        for (int i = 1; i < sticker.length; i++) {
            dp1[i] = sticker[i - 1];
            dp2[i] = sticker[i];
            if (i > 1){
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + dp1[i]);
                dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + dp2[i]);
            }
        }

        return Math.max(dp1[dp1.length - 1], dp2[dp2.length - 1]);
    }
}