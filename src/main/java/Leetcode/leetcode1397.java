package Leetcode;

import java.util.Arrays;

public class leetcode1397 {
    private char[] evils;
    private int m, n;
    private final int MOD = (int)(1e9) + 7;

    public static void main(String[] args) {
        leetcode1397 exec = new leetcode1397();
        System.out.println(exec.findGoodStrings(2, "aa", "da", "b"));
    }
    public int findGoodStrings(int n, String s1, String s2, String evil) {
        evils = evil.toCharArray();
        m = evils.length;
        this.n = n;
        int res = compute(s1) - compute(s2) + MOD;
        return res % MOD;
    }

    private int compute(String str) {
        char[] s = str.toCharArray();
        int[][] memo = new int[n][m + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(0, s, memo, false, m);
    }

    private int f(int i, char[] s, int[][] memo, boolean isLimit, int left) {
        if (i == n) {
            return 1;
        }
        if (!isLimit && memo[i][left] != -1) {
            return memo[i][left];
        }
        long res = 0;
        char up = isLimit ? s[i] : 'z';
        int alreadyCover = m - left;  //目前连续覆盖evil的长度
        for (char c = 'a'; c <= up; c++) {
            if (left == 1 && c == evils[m - 1]) {  //不能凑成evil
                continue;
            }
            res += f(i + 1, s, memo, isLimit && c == up, evils[alreadyCover] == c ? left - 1 : left);
        }
        res %= MOD;
        if (!isLimit) {
            memo[i][left] = (int)res;
        }
        return (int)res;
    }
}
