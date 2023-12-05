package Leetcode;

public class leetcode8 {
    public static void main(String[] args) {
        System.out.print(myAtoi("000123456"));
    }
    public static int myAtoi(String s) {
        int i = 0;
        boolean flag = false;
        boolean sign = false;
        boolean change = false;
        String result = "";
        String min = Integer.MIN_VALUE + "";
        String max = Integer.MAX_VALUE + "";
        int num;
        while(i < s.length()){
            if(s.charAt(i) == ' ' && flag == false){
                i++;
                continue;
            }
            if(s.charAt(i) == '-' && flag == false){
                if(sign == false){
                    change = true;
                    sign = true;
                    i++;
                    continue;
                }
                else
                    break;
            }
            if(s.charAt(i) == '+' && flag == false){
                if(sign == false){
                    sign = true;
                    i++;
                    continue;
                }
                else
                    break;
            }
            if(s.charAt(i) == '0'){
                if(flag == false){
                    i++;
                    continue;
                }
                else{
                    result += s.charAt(i);
                    i++;
                    continue;
                }
            }
            if(s.charAt(i) >= '1' && s.charAt(i) <= '9' ){
                result += s.charAt(i);
                flag = true;
                i++;
                continue;
            }
            if(s.charAt(i) < '0' || s.charAt(i) > '9'){
                break;
            }
        }
        if(result == "")
            return 0;
        if(change == true){
            if((result.compareTo(min.substring(1,11)) > 0 && result.length() >= 10) || result.length() > 10)
                return Integer.MIN_VALUE;
            else
                return -(Integer.parseInt(result));
        }
        else{
            if((result.compareTo(max) > 0 && result.length() >= 10) || result.length() > 10)
                return Integer.MAX_VALUE;
            else
                return Integer.parseInt(result);
        }
    }
}
