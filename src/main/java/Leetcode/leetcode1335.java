package Leetcode;

import java.util.Arrays;

public class leetcode1335 {

    int[][] dp;
    int[] jobDifficulty;

    public static void main(String[] args) {
        leetcode1335 exec = new leetcode1335();
        int[] jobDifficulty = {6,5,4,3,2,1};
        int res = exec.minDifficulty(jobDifficulty, 2);
        System.out.println(res);
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.jobDifficulty = jobDifficulty;
        int n = jobDifficulty.length;
        if (n < d) {  //任务数量不够
            return -1;
        }
        this.dp = new int[d + 1][n + 1];  //dp[i][j]表示用i天完成前n项工作的最小难度
        for (int i = 0; i <= d; i++) {
            Arrays.fill(dp[i], 300000);
        }
        return dfs(d, n);
    }

    public int dfs(int restDay, int restJob) {
        if (restDay == 1) {
            int res = 0;
            for (int i = 0; i < restJob; i++) {
                res = Math.max(res, jobDifficulty[i]);
            }
            return dp[1][restJob] = res;
        }
        if (dp[restDay][restJob] != 300000) {
            return dp[restDay][restJob];
        }
        int maxJob = restJob - restDay + 1;  //今天最多可以完成的工作数量
        int max = 0;  //今天的最大难度
        for (int i = 1; i <= maxJob; i++) {
            max = Math.max(max, jobDifficulty[restJob - i]);
            dp[restDay][restJob] = Math.min(dp[restDay][restJob], max + dfs(restDay - 1, restJob - i));
        }
        return dp[restDay][restJob];
    }
}
