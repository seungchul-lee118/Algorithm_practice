package bootcamp.example.lv3;

import java.util.*;

public class Toothbrush {
    public static void main(String[] args) {
        String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
        String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
        String[] seller1 = {"young", "john", "tod", "emily", "mary"};
        int[] amount1 = {12, 4, 2, 5, 10};
        String[] seller2 = {"sam", "emily", "jaimie", "edward"};
        int[] amount2 = {2, 3, 5, 4};

        System.out.println(Arrays.toString(solution(enroll, referral, seller1, amount1)));
        System.out.println(Arrays.toString(solution(enroll, referral, seller2, amount2)));
    }

    // 프로그래머스 lv.3 다단계 칫솔 판매

    public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            map.put(enroll[i], i);
        }
        for (int i = 0; i < seller.length; i++) {
            int idx = map.get(seller[i]);
            int earning = amount[i] * 100;
            answer[idx] += earning;

            while (earning >= 10) {
                earning *= 0.1;
                if (!referral[idx].equals("-")) {
                    answer[map.get(referral[idx])] += earning;
                    answer[idx] -= earning;
                    idx = map.get(referral[idx]);
                } else {
                    answer[idx] -= earning;
                    break;
                }
            }
        }
        return answer;
    }

}
