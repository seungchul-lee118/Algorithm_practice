package bootcamp.example.lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class HanoiTower {
    public static void main(String[] args) {
        int n1 = 2;
        int n2 = 4;
        int n3 = 3;

//        for (int[] ints : solution(n1)) {
//            System.out.println(Arrays.toString(ints));
//        }
//        System.out.println();
        for (int[] ints : solution(n2)) {
            System.out.println(Arrays.toString(ints));
        }
//        System.out.println();
//        for (int[] ints : solution(n3)) {
//            System.out.println(Arrays.toString(ints));
//        }

    }

    // 프로그래머스 lv.2 하노이의 탑

    public static int[][] solution(int n) {
        ArrayList<int[]> list = new ArrayList<>();
        hanoi(list,  n, 1, 2, 3);

        return list.toArray(new int[0][0]);
    }

    static void hanoi(List<int[]> list, int n, int start, int mid, int end) {
        if (n == 1) {
            list.add(new int[]{start, end});
            return ;
        }
        hanoi(list, n - 1, start, end, mid);
        list.add(new int[]{start, end});
        hanoi(list, n - 1, mid, start, end);
    }
}
