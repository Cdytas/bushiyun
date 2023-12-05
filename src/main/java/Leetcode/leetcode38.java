package Leetcode;

public class leetcode38 {

    public static void main(String[] args) {
        System.out.print(countAndSay(4));

    }
    public static String countAndSay(int n) {
        if(n == 1)
            return "1";
        if(n == 2)
            return "11";
        String str = countAndSay(n - 1);
        String res = "";
        int i = 0;
        int count = 1;
        while(i < str.length() - 1){
            if(str.charAt(i) == str.charAt(i+1)){
                count++;
                i++;
                if(i == str.length() - 1){
                    res = res + count + str.charAt(i);
                }
            }
            else{
                res = res + count + str.charAt(i);
                count = 1;
                i++;
            }
            if(i == str.length() - 1){
                if(str.charAt(i) != str.charAt(i - 1))
                    res = res + 1 + str.charAt(i);
            }
        }
        return res;
    }
}
