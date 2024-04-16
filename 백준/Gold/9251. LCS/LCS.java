import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s1 = sc.next();
		String s2 = sc.next();
		
		int[][] array = new int[s1.length() + 1][s2.length() + 1];
		int maxLength = 0;
		
		for (int i = 1; i <= s1.length(); i++) {
			char c1 = s1.charAt(i-1);
			for (int j = 1; j <= s2.length(); j++) {
				char c2 = s2.charAt(j-1);
				if (c1 == c2) {
					array[i][j] = array[i-1][j-1] + 1;
				} else {
					array[i][j] = Math.max(array[i][j-1], array[i-1][j]);
				}
				maxLength = Math.max(maxLength, array[i][j]);
			}
		}
		System.out.println(maxLength);
	}
}