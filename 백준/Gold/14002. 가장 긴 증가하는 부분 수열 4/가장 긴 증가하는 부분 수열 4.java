import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int[] nums = new int[A];
		int[] subArr = new int[A];
		int[] idxes = new int[A];
		int maxLength = 1;
		
		for (int i = 0; i < A; i++) {
			nums[i] = sc.nextInt();
		}
		
		subArr[0] = nums[0];
		for (int i = 1; i < A; i++) {
			for (int j = 0; j < maxLength; j++) {
				if (subArr[j] >= nums[i]) {
					subArr[j] = nums[i];
					idxes[i] = j;
					break;
				}
			}
			if (nums[i] > subArr[maxLength - 1]) {
				subArr[maxLength] = nums[i];
				idxes[i] = maxLength;
				maxLength++;
				continue;
			}
		}
		
		StringBuilder builder = new StringBuilder();
		int idx = maxLength - 1;
		
		for (int i = A - 1; i >= 0; i--) {
			if (idx == idxes[i]) {
				subArr[idx] = nums[i];
				idx--;
			}
			if (idx < 0) break;
		}
		
		for (int i = 0; i < maxLength; i++) {
			builder.append(subArr[i]).append(' ');
		}
		
		System.out.println(maxLength);
		System.out.println(builder);
	}
}