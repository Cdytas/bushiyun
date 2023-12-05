package Leetcode;

public class leetcode738 {
    public static void main(String[] args) {
        System.out.print(monotoneIncreasingDigits(668841));
    }

    public static int monotoneIncreasingDigits(int n) {
        String s = n + "";
        char[] sup = s.toCharArray();
        char[] res = new char[s.length()];
        boolean flag = true;
        for (int i = 0; i < s.length() - 1; i++) {
            if (sup[i] > sup[i + 1]) {
                flag = false;
                break;
            }
        }
        if (flag == true) {
            return n;
        }
        boolean fin = false;
        for (int i = 0; i < s.length() - 1; i++) {
            char c = sup[i];
            flag = false;
            for (int j = i + 1; j < s.length(); j++) {
                if (sup[j] < c) {
                    flag = true;
                    break;
                }
            }
            if (!flag || (flag && sup[i + 1] > sup[i])) {
                res[i] = c;
                continue;
            }
            else {
                res[i] = (char)(c - 1);
                fin = true;
            }
            if (fin) {
                for (int j = i + 1; j < s.length(); j++) {
                    res[j] = '9';
                }
                break;
            }
        }
        if (fin) {
            return Integer.parseInt(String.valueOf(res));
        }
        res[s.length() - 1] = res[s.length() - 2] == '9' ? '9' : (char)(res[s.length() - 2] + 1);
        String ss = String.valueOf(res);
        return Integer.parseInt(ss);
    }
}
