package Leetcode;

import java.util.Arrays;

public class leetcode2585 {
    public static void main(String[] args) {
        int[][] types = {{6,1},{3,2},{2,3}};
        System.out.println(waysToReachTarget(6,types));

    }

    public static int waysToReachTarget(int target, int[][] types) {
        int n = types.length;
        int MOD = (int)1e9 + 7;
        int[][] dp = new int[n][target + 1];
        for (int i = 0; i <= types[0][0]; i++) {
            if (i * types[0][1] > target) {
                break;
            }
            dp[0][i * types[0][1]] = 1;
        }
        for (int i = 1; i < n; i++) {
            dp[i] = Arrays.copyOf(dp[i - 1], target + 1);
            int score = types[i][1];
            int cnt = types[i][0];
            for (int j = 1; j <= cnt; j++) {
                int add = score * j;
                for (int k = 0; k <= target; k++) {
                    if (k + add > target) {
                        break;
                    }
                    dp[i][k + add] += dp[i - 1][k];
                    dp[i][k + add] %= MOD;
                }
            }
        }
        return dp[n - 1][target];
    }
}
