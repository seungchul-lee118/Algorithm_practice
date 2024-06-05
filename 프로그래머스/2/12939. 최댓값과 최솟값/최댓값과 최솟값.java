class Solution {
    public String solution(String s) {
        String answer = "";
        String[] s1 = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (String string : s1) {
            int num = Integer.parseInt(string);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        answer += min + " " + max;
        return answer;
    }
}