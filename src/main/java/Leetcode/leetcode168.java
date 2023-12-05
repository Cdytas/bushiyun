package Leetcode;

public class leetcode168 {
    public static void main(String[] args) {
        System.out.print(convertToTitle(52));
    }
    public static String convertToTitle(int columnNumber) {
        if(columnNumber <= 26){
            return ((char)(columnNumber - 1 + 'A')+"" ) ;
        }
        String s = "";
        StringBuilder build = new StringBuilder();
        int n;
        while(columnNumber > 26){
            n = columnNumber % 26;
            if(n == 0){
                build.append('Z');
                columnNumber = columnNumber / 26 - 1;
            }
            else{
                build.append((char)(n - 1 + 'A'));
                columnNumber = columnNumber / 26;
            }
        }
        build.append((char)(columnNumber -1 + 'A'));
        for(int i = build.length() - 1;i >= 0;i--)
            s += build.charAt(i);
        return s;
    }
}
