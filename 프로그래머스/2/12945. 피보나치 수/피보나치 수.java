class Solution {
    public int solution(int n) {
        int answer = 0;
        int[] fibo = new int[2];
        for (int i = 0; i <= n; i++) {
            if (i <=1) {
              fibo[i] = i;  
            } else {
                fibo[i % 2] = (fibo[0] + fibo[1])%1234567;
            }
        }
        answer = fibo[n % 2];
        return answer;
    }
}