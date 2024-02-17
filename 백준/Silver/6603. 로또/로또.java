import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int N = sc.nextInt();
            if (N == 0) break;
            int[] nums = new int[N];

            for (int i = 0; i < N; i++) {
                nums[i] = sc.nextInt();
            }
            Arrays.sort(nums);
            getCase(0, new ArrayList<>(), nums);
            System.out.println();
        }
    }

    static void getCase(int idx, List<Integer> list, int[] nums) {
        if (list.size() == 6 || idx >= nums.length) {
            if (list.size() == 6) {
                StringBuilder builder = new StringBuilder();
                for (Integer i : list) {
                    builder.append(i).append(' ');
                }
                System.out.println(builder);
            }
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            if (list.isEmpty() || nums[i] > list.get(list.size() - 1)) {
                list.add(nums[i]);
                getCase(idx + 1, list, nums);
                list.remove(Integer.valueOf(nums[i]));
            }
        }
    }
}