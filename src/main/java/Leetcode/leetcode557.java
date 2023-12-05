package Leetcode;

public class leetcode557 {
    public static void main(String[] args) {
        String s = "hehhhhhhe";
        System.out.print(reverseWords(s));
    }
    public static String reverseWords(String s) {
        int i = 0;
        int k = 0;
        boolean flag = false;
        boolean kongge = false;
        String str = "";
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                kongge = true;
                if(flag == false){
                    flag = true;
                    k = i;
                    for(int j = i - 1;j >= 0;j--){
                        str += s.charAt(j);
                    }
                }
                else{
                    for(int j = i;j > k;j--){
                        str += s.charAt(j);
                    }
                    k = i;
                }
                i++;
            }
            else{
                i++;
            }
        }
        if(kongge == false){
            for(int j = s.length() - 1;j >= 0;j--){
                str += s.charAt(j);
            }
            return str;
        }
        if(k != 0)
            str += " ";
        for(int j = s.length() - 1;j > k;j--){
            str += s.charAt(j);
        }
        return str;
    }
}
