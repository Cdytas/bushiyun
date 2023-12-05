package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode151 {
    public static void main(String[] args) {
        System.out.print(reverseWords("Ss   aaa dfg   gh   "));

    }
    public static String  reverseWords(String s) {
        int i = 0;
        boolean flag = false;
        List<String> list = new ArrayList<>();
        String str = "";
        while(i < s.length()){
            if(s.charAt(i) == ' '){
                if(flag == true ){
                    flag = false;
                    list.add(str);
                    str = "";
                }
                else{
                    str = "";
                }
                i++;
            }
            else{
                flag = true;
                str += s.charAt(i);
                i++;
                if(i == s.length()){
                    list.add(str);
                    break;
                }
            }
        }
        str = "";
        for(i = list.size() - 1;i > 0;i--){
            str += list.get(i) + " ";
        }
        str += list.get(0);
        return str;
    }
}
