package Leetcode;

public class leetcode844 {
    public static void main(String[] args) {
        String s  = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s, t));
    }

    public static  boolean backspaceCompare(String s, String t) {
        StringBuilder build1 = new StringBuilder();
        StringBuilder build2 = new StringBuilder();
        int countOfBack = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if (s.charAt(i) == '#') {
                countOfBack++;
            }
            else {
                if (countOfBack  > 0) {
                    countOfBack--;
                }
                else {
                    build1.append(s.charAt(i));
                }
            }
        }
        countOfBack = 0;
        for (int i = t.length() - 1; i >= 0; i--) {
            if (t.charAt(i) == '#') {
                countOfBack++;
            }
            else {
                if (countOfBack  > 0) {
                    countOfBack--;
                }
                else {
                    build2.append(t.charAt(i));
                }
            }
        }
        return build1.toString().equals(build2.toString());
    }
}
