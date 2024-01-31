import java.util.Scanner;

public class Main
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T= sc.nextInt();
		int count = 0;
		for (int i = 0; i < T; i++) {
			int num = sc.nextInt();
			if (num < 2) {
				continue;
			}
			if (isPrime(num)) {
				count++;
			}
		}
		System.out.println(count);
	}

	static boolean isPrime(int num) {
		if (num <= 3) {
			return true;
		}
		for (int i = 2; i <= Math.sqrt(num); i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}
}
