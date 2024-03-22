import java.util.*;

class Solution {
    int subScore = 0;
    
    public int[] solution(int n, int[] info) {
        int[] answer = new int[11];
        subScore = 0;
        
        backTrack(n, 0, new int[11], info, answer);
        int sum = 0;
        for (int i = 0; i < answer.length; i++) {
            sum += answer[i];
        }
        if (sum < n) answer[10] = n - sum;
        
        return subScore == 0 ? new int[] {-1} : answer;
    }
    
    public void backTrack(int n, int idx, int[] ryan, int[] apeach, int[] answer) {
        if (idx == n) {
            if (subScore <= calculate(ryan, apeach)) {
				subScore = calculate(ryan, apeach);
				for (int i =0; i < answer.length; i++) {
                    answer[i] = ryan[i];
                }
            }
            return;
        }
        
        for (int i = 0; i < ryan.length && ryan[i] <= apeach[i]; i++) {
            ryan[i] ++;
            backTrack(n, idx + 1, ryan, apeach, answer);
            ryan[i]--;
        }

    }
    
    public int calculate(int[] ryan, int[] apeach) {
        int sum = 0;
        for (int i = 0; i < 11; i++) {
            if (ryan[i] + apeach[i] == 0) continue;
            if (ryan[i] > apeach[i]) sum += (10 -i);
            else sum -= (10 - i);
        }
        return sum < 0 ? -1 : sum;
    }
}