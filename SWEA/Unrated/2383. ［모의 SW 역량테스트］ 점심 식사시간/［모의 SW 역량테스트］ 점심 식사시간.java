import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N, peopleNum, minTime;
	static List<int[]> peoples;
	static List<int[]> stairs;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			peoples = new ArrayList<>();
			stairs = new ArrayList<>();
			
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					int temp = sc.nextInt();
					if (temp == 1) {
						peoples.add(new int[] {r, c});
					} else if (temp > 1) {
						stairs.add(new int[] {r, c, temp});
					}
				}
			}
			minTime = 10000;
			peopleNum = peoples.size();
			
			for (int i = 0; i < (1<<peopleNum); i++) {
				findTime(i);
			}
			
			System.out.println("#" + tc + " " + (minTime + 1));
		}
	}
	
	public static void findTime(int subset) {
		PriorityQueue<Integer> queue1 = new PriorityQueue<>();
		PriorityQueue<Integer> queue2 = new PriorityQueue<>();
		int length1 = 0;
		int length2 = 0;
		
		for (int i = 0; i < peopleNum; i++) {
			if (((1 << i) & subset) > 0) {
				int[] people = peoples.get(i);
				int[] stair = stairs.get(1);
				length2 = stair[2];
				queue2.add(dist(people[0], people[1], stair[0], stair[1]));
			} else {
				int[] people = peoples.get(i);
				int[] stair = stairs.get(0);
				length1 = stair[2];
				queue1.add(dist(people[0], people[1], stair[0], stair[1]));				
			}
		}
		
		Queue<Integer> tempQueue = new LinkedList<>();
		while (!queue1.isEmpty()) {
			int arrived = queue1.poll();
			if (tempQueue.size() < 3) {
				tempQueue.add(arrived + length1);
			} else {
				int temp = tempQueue.poll();
				tempQueue.add(Math.max(temp, arrived) + length1);
			}
		}
		int time1 = 0;
		while (!tempQueue.isEmpty()) {
			time1 = tempQueue.poll();
		}
		
		while (!queue2.isEmpty()) {
			int arrived = queue2.poll();
			if (tempQueue.size() < 3) {
				tempQueue.add(arrived + length2);
			} else {
				int temp = tempQueue.poll();
				tempQueue.add(Math.max(temp, arrived) + length2);
			}
		}
		int time2 = 0;
		while (!tempQueue.isEmpty()) {
			time2 = tempQueue.poll();
		}
		
		minTime = Math.min(minTime, Math.max(time1, time2));
	}
	
	public static int dist(int r1, int c1, int r2, int c2) {
		return Math.abs(r1 - r2) + Math.abs(c1 - c2);
	}
}