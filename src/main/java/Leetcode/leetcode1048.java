package Leetcode;
import  java.util.*;
public class leetcode1048 {
    public static void main(String[] args) {
        String[] words = {"bdca","bda","ca","dca","a"};
        System.out.print(longestStrChain(words));
    }

    public static int longestStrChain(String[] words) {
        int n = words.length;
        int res = 0;
        Arrays.sort(words, Comparator.comparingInt(String::length));
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            String s1 = words[i];
            for (int j = i - 1; j >= 0; j--) {
                String s2 = words[j];
                if (s2.length() == s1.length() - 1) {
                    int count = 0;
                    int index1 = 0;
                    int index2 = 0;
                    boolean flag = true;
                    while (index1 < s1.length() && index2 < s2.length()) {
                        if (s1.charAt(index1) == s2.charAt(index2)) {
                            index1++;
                            index2++;
                        }
                        else {
                            count++;
                            index1++;
                            if (count >= 2) {
                                flag = false;
                                break;
                            }
                        }
                    }
                    if (flag) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
                else if (s2.length() < s1.length() - 1){
                    break;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
