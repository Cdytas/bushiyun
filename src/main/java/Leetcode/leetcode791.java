package Leetcode;

public class leetcode791 {
    public static void main(String[] args) {
        String order = "cbafg";
        String s = "abcddefgc";
        System.out.print(customSortString(order,s));
    }
    public static String customSortString(String order, String s) {
        StringBuilder build = new StringBuilder();
        boolean []flag = new boolean[s.length()];
        for(int i = 0; i < order.length();i++){
            for(int j = 0;j < s.length();j++){
                if(s.charAt(j) == order.charAt(i)){
                    build.append(s.charAt(j));
                    flag[j] = true;
                }
            }
        }
        for(int i = 0; i < flag.length;i++){
            if(flag[i] == false)
                build.append(s.charAt(i));
        }
        return build.toString();
    }
}
