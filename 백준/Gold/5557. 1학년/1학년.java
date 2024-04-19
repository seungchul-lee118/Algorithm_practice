

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		StringTokenizer st = new StringTokenizer(in.readLine());
		int[] arr = new int[N-2];
		long[] numVal = new long[21];
		numVal[Integer.parseInt(st.nextToken())]++;
//		System.out.println(Arrays.toString(numVal));
		for(int i = 0; i<N-2; i++) {
			int input = Integer.parseInt(st.nextToken());
//			System.out.println(input);
			long[] plus = new long[21];
			long[] minus = new long[21];
			for(int j = 0; j<=20; j++) {
				if((j-input) >= 0)
					minus[j-input] = numVal[j];
				if((j+input) <= 20)
					plus[j+input] = numVal[j];
			}
//			System.out.println(i+" : ");
//			System.out.println(Arrays.toString(plus));
//			System.out.println(Arrays.toString(minus));
			
			for(int j = 0; j<=20; j++) {
				numVal[j] = minus[j] + plus[j];
			}
		}
		System.out.println(numVal[Integer.parseInt(st.nextToken())]);
	}
}
