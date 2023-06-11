package bootcamp.example.lv3;

import java.util.*;

public class Balloon {
    public static void main(String[] args) {
        int[] a1 = {9, - 1, -5};
        int[] a2 = {-16, 27, 65, -2, 58, -92, -71, -68, -61, -33};

        System.out.println(solution(a1));
        System.out.println(solution(a2));
        System.out.println(solutionRef(a1));
        System.out.println(solutionRef(a2));
    }

    // 프로그래머스 Lv.3 풍선 터트리기

    public static int solution(int[] a) {
        int answer = 0;
        int minLeft = 1000000001;
        int right = 1000000001;
        int[] minRight = new int[a.length];
        for (int i = a.length-1; i >= 0; i--) {
            right = Math.min(right, a[i]);
            minRight[i] = right;
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] < minLeft || a[i] <= minRight[i]) {
                answer++;
            }
            minLeft = Math.min(minLeft, a[i]);
        }
        return answer;
    }

    // 다른 사람 풀이 풀이
    public static int solutionRef(int[] a) {
        int min1 = 1000000001;
        int min2 = 1000000001;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length/2 + 1; i++) {
            min1 = Math.min(min1, a[i]);
            min2 = Math.min(min2, a[a.length - 1 - i]);
            set.add(min1);
            set.add(min2);
        }
        return set.size();
    }
}