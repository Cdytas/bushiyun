package Leetcode;

public class leetcode28 {
    public static void main(String[] args) {
        String s1 = "mississippi";
        String s2 = "issip";
        System.out.print(strStr(s1,s2));

    }
    public static int strStr(String haystack, String needle) {
        int i = 0;
        int j = 0;
        int i2 = 0;
        int length = 0;
        while(i < haystack.length()){
                if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                length++;
                if(length == needle.length())
                    return i - needle.length();
            }
            else{
                i++;
                j = 0;
                length = 0;
            }
        }
        return -1;
    }
}
