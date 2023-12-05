package Leetcode;
import java.util.*;
public class leetcode438 {
    public static void main(String[] args) {
        leetcode438 exec = new leetcode438();
        List<Integer> res = exec.findAnagrams("abab", "ab");
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int m = s.length();
        int n = p.length();
        if (m < n) {
            return res;
        }
        int[] cnt = new int[26];
        int[][] preSum = new int[m + 1][26];
        for (int i = 0; i < n; i++) {
            cnt[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            preSum[i + 1] = Arrays.copyOf(preSum[i], 26);
            int num = s.charAt(i) - 'a';
            preSum[i + 1][num] = preSum[i][num] + 1;
        }
        for (int i = n; i <= m; i++) {
            boolean flag = true;
            for (int j = 0; j < 26; j++) {
                if (preSum[i][j] - preSum[i - n][j] != cnt[j]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(i - n);
            }
        }
        return res;
    }

}
