package bootcamp.example.lv2;

import java.util.*;

public class Defense {
    public static void main(String[] args) {
        int n1 = 7;
        int k1 = 3;
        int[] enemy1 = {4, 2, 4, 5, 3, 3, 1};

        int n2 = 2;
        int k2 = 4;
        int[] enemy2 = {3, 3, 3, 3};

        int n3 = 7;
        int k3 = 2;
        int[] enemy3 = {2, 1, 99, 99};

        int n4 = 7;
        int k4 = 1;
        int[] enemy4 = {2, 1, 5, 1};

        System.out.println(solution(n1, k1, enemy1));
        System.out.println(solution(n2, k2, enemy2));
        System.out.println(solution(n3, k3, enemy3));
        System.out.println(solution(n4, k4, enemy4));
    }

    // 프로그래머스 lv.2 디펜스 게임

    public static int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> skills = new PriorityQueue<>();
        for (int i = 0; i < enemy.length; i++) {
            int num = enemy[i];
            if (skills.size() == k) {
                Integer minSkill = skills.poll();
                if(n < Math.min(num, minSkill)) break;
                n -= Math.min(num, minSkill);
                skills.offer(Math.max(num, minSkill));
            } else {
                skills.offer(num);
            }
            answer++;
        }
        return answer;
    }
}