package Leetcode;
import java.util.*;
public class leetcode140 {

    String s;
    int len;
    List<String> res = new ArrayList<>();
    List<String> wordDict;
    Map<String, Integer> memo = new HashMap<>();

    public static void main(String[] args) {
        leetcode140 exec = new leetcode140();
        List<String> wordDict = new ArrayList<>();
        wordDict.add("a");
        List<String> res = exec.wordBreak("a", wordDict);
        for (String s : res) {
            System.out.print(s + " ");
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        this.len = s.length();
        for (int i = 1; i <= Math.min(len,10); i++) {
            dfs("", 0, i);
        }
        return res;
    }

    public void dfs(String str, int start, int end) {
        String t = s.substring(start, end);
        if (memo.containsKey(t) || find(t)) {
            if (end == len) {
                str += t;
                res.add(str);
                return;
            }
            str += t + " ";
            for (int i = end + 1; i <= Math.min(end + 10, len); i++) {
                dfs(str, end, i);
            }
        }
    }

    public boolean find(String t) {
        for (int i = 0; i < wordDict.size(); i++) {
            if (t.equals(wordDict.get(i))) {
                memo.put(t, 1);
                return true;
            }
        }
        return false;
    }
}
