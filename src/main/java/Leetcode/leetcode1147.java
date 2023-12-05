package Leetcode;
import java.util.*;
public class leetcode1147 {

    int[][] memo;
    String text;

    public static void main(String[] args) {
        leetcode1147 exc = new leetcode1147();
        String text = "ghiabcdefhelloadamhelloabcdefghi";
        System.out.println(exc.longestDecomposition(text));
    }
    public int longestDecomposition(String text) {
        int n = text.length();
        memo = new int[n][n];
        this.text = text;
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return longest(0, n - 1);
    }

    public int longest(int start, int end) {
        if (memo[start][end] != -1) {
            return memo[start][end];
        }
        if (start > end) {
            memo[start][end] = 0;
            return 0;
        }
        if (start == end) {
            memo[start][end] = 1;
            return 1;
        }
        int begin = (start + end) / 2 + 1;
        char c = text.charAt(start);
        int max = 1;
        for (int i = begin; i <= end; i++) {
            if (text.charAt(i) == c) {
                int len = end - i + 1;
                String str1 = text.substring(start, start + len);
                String str2 = text.substring(i, end + 1);
                if (str1.equals(str2)) {
                    max = Math.max(max, longest(start + len, i - 1) + 2);
                }
            }
        }
        memo[start][end] = max;
        return max;
    }
}
