package bootcamp.example.lv2;

public class NQueen {
    public static void main(String[] args) {
        int n = 4;

        System.out.println(solution(n)); //2
    }

    // 프로그래머스 lv.2 N-Queen

    public static int solution(int n) {
        int answer = 0;
        int[] array = new int[n];

        answer = find(0, n, array);
        return answer;
    }

    static int find(int depth, int n, int[] array) {
        if (depth == n) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            array[depth] = i;
            if (valid(array, depth)) {
                result += find(depth + 1, n, array);
            }
        }
        return result;
    }
    
    static boolean valid(int[] array, int col) {
        for (int i = 0; i < col; i++) {
            if (array[col] == array[i]) return false;
            if (Math.abs(col - i) == Math.abs(array[col] - array[i])) return false;
        }
        return true;
    }
}