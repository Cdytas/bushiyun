package Leetcode;

import java.util.Arrays;

public class leetcode2172 {

    int n;
    int[] nums;
    int[][] memo;

    public static void main(String[] args) {
        leetcode2172 exec = new leetcode2172();
        int res = exec.maximumANDSum(new int[]{1,2}, 1);
        System.out.print(res);
    }
    public int maximumANDSum(int[] nums, int numSlots) {
        this.nums = nums;
        n = nums.length;
        memo = new int[numSlots + 1][1 << n];
        for (int i = 1; i <= numSlots; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(numSlots, (1 << n) - 1);
    }


    private int dfs(int basket, int mask) {
        if (memo[basket][mask] != -1) {
            return memo[basket][mask];
        }
        if (mask == 0) {  //鸡蛋没了
            return 0;
        }
        if (basket == 1) {  //只剩一个篮子
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1) {  //下标i的坤蛋还未装入篮子
                    sum += nums[i] & 1;
                }
            }
            return memo[1][mask] = sum;
        }
        int remain = Integer.bitCount(mask);  //还有几组坤蛋没装
        int least = 0;  //本篮子至少装几个坤蛋
        int res = 0;
        if (remain == 2 * basket - 1) {
            least = 1;
        }
        if (remain == 2 * basket) {
            least = 2;
        }
        if (least == 0) {
            res = dfs(basket - 1, mask); //该篮子可以不装
        }
        for (int j = mask; j > 0; j = (j - 1) & mask) {
            int cnt = Integer.bitCount(j);
            if (cnt >= least && cnt <= 2) {  //可行
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    if ((j >> i & 1) == 1) {
                        sum += nums[i] & basket;
                    }
                }
                res = Math.max(res, sum + dfs(basket - 1, mask ^ j));
            }
        }
        return memo[basket][mask] = res;
    }
}
