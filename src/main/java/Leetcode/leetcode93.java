package Leetcode;
import java.util.*;
public class leetcode93 {
    List<String> res = new ArrayList<>();
    String s;
    int len;

    public static void main(String[] args) {
        leetcode93 exc = new leetcode93();
        String s  = "25525511135";
        List<String> res = exc.restoreIpAddresses(s);
        for (String str : res) {
            System.out.print(str +"  ");
        }
    }
    public List<String> restoreIpAddresses(String s) {
        this.s = s;
        this.len = s.length();
        if(len > 12 || len < 4) {
            return res;
        }
        dfs(0, len, "", 0);
        return res;
    }

    public void dfs(int start, int remain, String str, int count) {
        if (remain > 3 * (4 - count)) { //剩下的次数无法将s用完
            return;
        }
        if (remain == 0 && count == 4) {
            String sup = str.substring(0, str.length() - 1);
            res.add(sup);
            return;
        }
        if (remain > 0 && count == 4) {
            return;
        }
        for (int i = 1; i <= 3; i++) {
            if (start + i > len) {
                break;
            }
            String sup = s.substring(start, start + i);
            if (check(sup)) {
                dfs(start + i, remain - i, str + sup + ".", count + 1);   //str本就是局部变量，无需回溯
            }
        }
    }

    public boolean check(String s) {
        if (s.length() == 1) {
            return true;
        }
        if (s.length() == 2) {
            if (s.charAt(0) == '0') {
                return false;
            }
            return true;
        }
        else {
            int num = Integer.parseInt(s);
            if (num < 100 || num > 255) {
                return false;
            }
            return true;
        }
    }

}
