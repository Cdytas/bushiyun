package Leetcode;

import java.util.Arrays;

public class leetcode322 {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        System.out.println(coinChange(coins , 11));
    }

    public static int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int[] dp = new int[amount + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            int index = 0;
            for (int j = 0; j < coins.length; j++) {
                if (i >= coins[j]) {
                    index++;
                }
                else {
                    break;
                }
            }
            if (index == 0) {
                dp[i] = -1;
                continue;
            }
            int min = 10001;
            for (int j = 0; j < index; j++) {
                if (dp[i - coins[j]] == -1) {
                    continue;
                }
                min = Math.min(min, dp[i - coins[j]]);
            }
            if (min == 10001) {
                dp[i] = -1;
            }
            else {
                dp[i] = min + 1;
            }
        }
        return dp[amount];
    }

}
