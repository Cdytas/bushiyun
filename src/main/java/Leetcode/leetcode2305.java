package Leetcode;

import java.util.Arrays;

public class leetcode2305 {
    int[][] memo;
    int[] sum;

    public static void main(String[] args) {
        leetcode2305 exec = new leetcode2305();
        int[] cookies = {13,3};
        System.out.print(exec.distributeCookies(cookies, 2));
    }
    public int distributeCookies(int[] cookies, int k) {
        int n = cookies.length;
        int u = 1 << n;  //全集
        memo = new int[k + 1][u];
        sum = new int[u];
        for (int i = 0; i < n; i++) {  //预处理每个集合包含的饼干总数
            int h = 1 << i;
            for (int j = 0; j < h; j++) {
                sum[j | h] = sum[j] + cookies[i];
            }
        }
        for (int i = 2; i <= k; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(k, u - 1);
    }

    private int dfs(int i, int j) {
        if (i == 1) {  //只剩一个孩子，全给他
            return sum[j];
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int res = Integer.MAX_VALUE;
        for (int k = j; k > 0; k = (k - 1) & j) {  //枚举j的子集分给第i个孩子
            if (Integer.bitCount(j ^ k) < i - 1) {  //剩下的饼干包个数不够剩下的孩子分
                continue;
            }
            res = Math.min(res, Math.max(sum[k], dfs(i - 1, j ^ k)));
        }
        return memo[i][j] = res;
    }

}
