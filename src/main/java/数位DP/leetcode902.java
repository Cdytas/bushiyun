package 数位DP;
import java.util.*;
public class leetcode902 {

    int m;
    char[] s;
    int[] number;
    int[] memo;

    public static void main(String[] args) {
        leetcode902 exec = new leetcode902();
        String[] digits = {"7"};
        System.out.println(exec.atMostNGivenDigitSet(digits, 8));
    }
    public int atMostNGivenDigitSet(String[] digits, int n) {
        s = Integer.toString(n).toCharArray();
        m = digits.length;
        number = new int[m];
        for (int i = 0; i < m; i++) {
            number[i] = digits[i].charAt(0) - '0';
        }
        memo = new int[s.length];
        Arrays.fill(memo, -1);
        return f(0, true, false);
    }

    private int f(int i, boolean isLimit, boolean haveNum) {
        if (i == s.length) {
            return haveNum ? 1 : 0;
        }
        if (!isLimit && haveNum && memo[i] != -1) {
            return memo[i];
        }
        int res = 0;
        if (!haveNum) {
            res += f(i + 1, false, false);
        }
        int up = isLimit ? s[i] - '0' : number[m - 1];
        for (int index = 0; index < m; index++) {
            if (number[index] > up) {
                break;
            }
            res += f(i + 1, isLimit && number[index] == up, true);
        }
        if (!isLimit && haveNum) {
            memo[i] = res;
        }
        return res;
    }
}
