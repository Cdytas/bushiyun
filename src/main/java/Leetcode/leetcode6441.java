package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode6441 {

    boolean flag = false;

    public static void main(String[] args) {
        int res = 0;
        leetcode6441 exec = new leetcode6441();
        List<Integer> ans = exec.punishmentNumber(37);
        for (int x : ans) {
            res += x * x;
        }
        System.out.println(res);
    }
    public List<Integer> punishmentNumber(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            int sup = i * i;
            dfs(sup + "", 0, 0, i);
            if (flag) {
                res.add(i);
                flag = false;
            }
        }
        return res;
    }


    public void dfs(String s, int start, int sum, int n) {
        if (sum > n) {
            return;
        }
        if (start == s.length()) {
            if (sum == n) {
                flag = true;
            }
            return;
        }
        int max = s.length() - start;
        for (int i = 1; i <= max; i++) {
            dfs(s, start + i, sum + swit(s.substring(start, start + i)), n);
            if (flag) {
                return;
            }
        }
    }

    public int swit(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            res = res * 10 + str.charAt(i) - '0';
        }
        return res;
    }
}
