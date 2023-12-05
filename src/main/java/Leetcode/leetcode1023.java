package Leetcode;
import java.util.*;
public class leetcode1023 {
    public static void main(String[] args) {
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String pattern = "FB";
        List<Boolean> res = camelMatch(queries, pattern);
        for (boolean flag : res) {
            System.out.print(flag + " ");
        }

    }

    public static List<Boolean> camelMatch(String[] queries, String pattern) {
        int countOfUpper = 0;
        List<Boolean> res = new ArrayList<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (pattern.charAt(i) >= 'A' && pattern.charAt(i) <= 'Z') {
                countOfUpper++;
            }
        }
        for (int i = 0; i < queries.length; i++) {
            String str = queries[i];
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) >= 'A' && str.charAt(j) <= 'Z' ) {
                    count++;
                }
            }
            if (count > countOfUpper) {
                res.add(false);
                continue;
            }
            int j = 0;
            int k = 0;
            while (j < str.length() && k < pattern.length()) {
                if (str.charAt(j) == pattern.charAt(k)) {
                    j++;
                    k++;
                }
                else {
                    j++;
                }
                if (j == str.length() && k != pattern.length()) {
                    res.add(false);
                    break;
                }
                if (k == pattern.length()) {
                    res.add(true);
                    break;
                }
            }
        }
        return res;
    }
}
