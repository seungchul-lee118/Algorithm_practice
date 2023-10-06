package bootcamp.example.lv3;

import java.util.*;

public class DiskController {
    public static void main(String[] args) {
        int[][] jobs = {{0,3}, {1,9}, {2,6}};
        int[][] jobs1 = {{0,7}, {1,9}, {2,6}, {0,2}};
        int[][] jobs2 = {{24, 10}, {28, 39}, {43, 20},
            {37, 5}, {47, 22}, {20, 47}, {15, 34}, {15, 2}, {35, 43}, {26, 1}};
        System.out.println(solution(jobs));
//        System.out.println(solution(jobs1));
//        System.out.println(solution(jobs2));
    }

    // 프로그래머스 Lv.3 디스크 컨트롤러

    public static int solution(int[][] jobs) {
        int answer = 0;
        int endTime = 0;
        int idx = 0;

        // 우선순위 큐 : 대기중인 작업들, 정렬 기준 : 더 짧은 요청
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparing(o -> o[1]));
        // 1. 더 빨리 요청, 2. 같을 경우 더 짧은 요청 기준으로 정렬
        Arrays.sort(jobs, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });

        while (!queue.isEmpty() || idx < jobs.length) {
            if (idx < jobs.length && (jobs[idx][0] <= endTime)) {
                queue.add(jobs[idx]);
                idx++;
            } else {
                if (queue.isEmpty()) {
                    queue.add(jobs[idx]);
                    idx++;
                }
                int[] nextJob = queue.poll();
                endTime = (endTime > nextJob[0]) ? (endTime + nextJob[1]) : (nextJob[0] + nextJob[1]);
                answer += endTime - nextJob[0];
            }
        }
        answer /= jobs.length;
        return answer;
    }
}
