import java.util.Scanner;

public class Solution {
	static int[] counts;
	static int[] operators;
	static int[] nums;
	static int N, minResult, maxResult;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			// +, -, *, /
			operators = new int[N - 1];
			nums = new int[N];
			counts = new int[5];
			maxResult = -100000000;
			minResult = 100000000;
			
			for (int i = 1; i <= 4; i++) {
				counts[i] = sc.nextInt();
			}
			for (int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			combWithRep(0, 0, 0, 0, 0);
			
			System.out.println("#" + tc + " " + (maxResult - minResult));
		}
	}
	
	public static void combWithRep(int idx, int count1, int count2, int count3, int count4) {
		if (count1 > counts[1] || count2 > counts[2] || count3 > counts[3] || count4 > counts[4]) return;
		if (idx >= N - 1) {
			calculate();
			return ;
		}
		for (int i = 1; i <= 4; i++) {
			if (i == 1) {
				operators[idx] = i;
				combWithRep(idx + 1, count1+1 ,count2, count3, count4);
			} else if (i == 2) {
				operators[idx] = i;
				combWithRep(idx + 1, count1 ,count2+1, count3, count4);
			} else if (i == 3) {
				operators[idx] = i;
				combWithRep(idx + 1, count1 ,count2, count3+1, count4);
			} else {
				operators[idx] = i;
				combWithRep(idx + 1, count1, count2, count3, count4+1);
			}
		}
		
	}
	
	public static void calculate() {
		int temp = nums[0];
		for (int i = 0; i < N-1; i++) {
			if (operators[i] == 1) {
				temp = temp + nums[i+1];
			} else if (operators[i] == 2) {
				temp = temp - nums[i+1];
			} else if (operators[i] == 3) {
				temp = temp * nums[i+1];
			} else {
				temp = temp / nums[i+1];
			}
		}
		minResult = Math.min(minResult, temp);
		maxResult = Math.max(maxResult, temp);
	}
}
