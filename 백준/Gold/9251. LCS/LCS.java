import java.util.Arrays;
import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input1 = sc.next();
		String input2 = sc.next();
//		int dif = input1.length() - input2.length();
		//input1이 더 작은 경우 -> 바꿀거 바꾸고 추가하기
//		if(dif < 0 ) {
//			System.out.println();
//		}
//		else if
		
		int res = LCS(input1, input2);
		
		System.out.println(res);
	}

	private static int LCS(String input1, String input2) {
		int[][] dp = new int[input1.length()][input2.length()];
		
		for(int i = 0 ;i< input1.length(); i++) {
			if(input1.charAt(i) == input2.charAt(0))
				dp[i][0] = 1;
			else {
				if(i != 0)
				dp[i][0] = dp[i-1][0];
			}
		}
		
		for(int j = 0 ;j< input2.length(); j++) {
			if(input1.charAt(0) == input2.charAt(j))
				dp[0][j] = 1;
			else {
				if(j != 0)
				dp[0][j] = dp[0][j-1];
			}
		}
		
		for(int i = 1 ;i<input1.length(); i++) {
			for(int j = 1; j<input2.length(); j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if(input1.charAt(i) == input2.charAt(j))
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
			}
		}
//		for(int i =0 ;i<input1.length();i++)
//			System.out.println(Arrays.toString(dp[i]));
//		
		return dp[input1.length()-1][input2.length()-1];
	}
}
