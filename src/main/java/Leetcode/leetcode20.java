package Leetcode;

public class leetcode20 {
    public static void main(String[] args) {
        System.out.print(isValid("({{(2)}})[1]{3}"));

    }
    public static boolean isValid(String s) {
        int i = 0,j = 0;
        StringBuilder str = new StringBuilder();  //用于存放左边的括号、中括号、花括号
        for(i = 0;i < s.length();i++){
            if(s.charAt(i) == '('){
                str.append('(');
                j++;
                continue;
            }
            if(s.charAt(i) == '['){
                str.append('[');
                j++;
                continue;
            }
            if(s.charAt(i) == '{'){
                str.append('{');
                j++;
                continue;
            }
            if(s.charAt(i) == ')'){
                if(j == 0)
                    return false;
                if(str.charAt(j - 1) == '('){
                    str.deleteCharAt(j - 1);
                    j--;
                    continue;
                }
                else
                    return false;
            }
            if(s.charAt(i) == ']'){
                if(j == 0)
                    return false;
                if(str.charAt(j - 1) == '['){
                    str.deleteCharAt(j - 1);
                    j--;
                    continue;
                }
                else
                    return false;
            }
            if(s.charAt(i) == '}'){
                if(j == 0)
                    return false;
                if(str.charAt(j - 1) == '{'){
                    str.deleteCharAt(j - 1);
                    j--;
                }
                else
                    return false;
            }
        }
        if(j == 0)
            return true;
        else
            return false;
    }
}
