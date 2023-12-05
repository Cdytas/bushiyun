package Leetcode;

public class leetcode541 {
    public static void main(String[] args) {
        String s = "abcdefg";
        System.out.println(reverseStr(s, 2));

    }

    public static String reverseStr(String s, int k) {
        int len = s.length();
        int start = 0;
        int count = len / (2 * k);
        boolean flag = len % (2 * k) >= k ? true : false;
        char[] res = s.toCharArray();
        while (count != 0) {
            swap(res, start, start + k - 1);
            start += 2 * k;
            count--;
        }
        if (flag) {
            swap(res, start, start + k - 1);
        }
        else {
            swap(res, start, len - 1);
        }
        return String.valueOf(res);
    }

    public static void swap(char[] res, int i, int j) {
        while (i < j) {
            char c = res[i];
            res[i] = res[j];
            res[j] = c;
            i++;
            j--;
        }
    }
}
