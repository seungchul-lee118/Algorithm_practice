import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        int result = queens(0, arr);
        
        System.out.println(result);
    }

    static int queens(int idx, int[] arr) {
        if (idx == arr.length) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[idx] = i;
            if (isValid(arr, idx)) {
                result += queens(idx + 1, arr);
            }
        }
        return result;
    }

    static boolean isValid(int[] arr, int idx) {
        for (int i = 0; i < idx; i++) {
            if (arr[i] == arr[idx]) {
                return false;
            }
            if (Math.abs(i - idx) == Math.abs(arr[i] - arr[idx])) {
                return false;
            }
        }
        return true;
    }
}