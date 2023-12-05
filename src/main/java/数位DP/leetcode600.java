package 数位DP;

import java.util.Arrays;

public class leetcode600 {

    char[] s;
    int[][] memo;

    public static void main(String[] args) {
        leetcode600 exec = new leetcode600();
        int res = exec.findIntegers(6);
        System.out.println(res);
    }
    public int findIntegers(int n) {
        s = Integer.toBinaryString(n).toCharArray();
        int m = s.length;
        memo = new int[m][2];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return f(0, 0, true, false);
    }

    private int f(int i, int pre, boolean isLimit, boolean haveNum) {
        if (i == s.length) {  //已找到一种方案
            return 1;
        }
        if (!isLimit && haveNum && memo[i][pre] != -1) {
            return memo[i][pre];
        }
        int res = 0;
        if (!haveNum) {
            res += f(i + 1, 0, false, false);
        }
        int up = isLimit ? s[i] - '0' : 1;
        if (pre == 1) {
            up = 0;  //不受限但是前一位填的是1
        }
        for (int d = haveNum ? 0 : 1; d <= up; d++) {
            res += f(i + 1, d, isLimit && d == s[i] - '0', true);
        }
        if (!isLimit && haveNum) {
            memo[i][pre] = res;
        }
        return res;
    }

}
