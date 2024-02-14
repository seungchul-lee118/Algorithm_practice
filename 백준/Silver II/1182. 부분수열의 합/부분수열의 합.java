import java.util.*;

public class Main {
    static int count;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int S = sc.nextInt();
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        getCount( 0, S, 0, nums);
        if (S == 0) count--;
        System.out.println(count);
    }

    static void getCount(int idx, int target, int sum, int[] nums) {
        if (idx == nums.length) {
            if (sum == target) {
                count++;
            }
            return;
        }
        getCount(idx + 1, target, sum + nums[idx], nums);
        getCount(idx + 1, target, sum, nums);
    }
}