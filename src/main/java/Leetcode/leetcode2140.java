package Leetcode;

public class leetcode2140 {
    public static void main(String[] args) {
        int[][] questions = {{3,2},{4,3},{4,4},{2,5}};
        System.out.print(mostPoints(questions));
    }
    public static long mostPoints(int[][] questions) {
        long res = 0;
        int n = questions.length;
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            dp[i] = questions[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (questions[j][1] + j < i) {
                    dp[i] = Math.max(dp[i], dp[j] + questions[i][0]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
