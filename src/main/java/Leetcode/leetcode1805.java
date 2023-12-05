package Leetcode;

import java.util.ArrayList;

public class leetcode1805 {
    public static void main(String[] args) {
        String word = "5a5";
        System.out.print(numDifferentIntegers(word));
    }
    public static int numDifferentIntegers(String word) {
        if(word.length() == 1){
            if(word.charAt(0) >= '0' && word.charAt(0) <= '9')
                return 1;
            else
                return 0;
        }
        ArrayList<String> list =  new ArrayList<>();
        int left = 0;
        int right = 0;
        int i = 0;
        boolean flag = false;
        int zero = 0;
        while(left < word.length() && right < word.length() && i < word.length()){
            if(word.charAt(i) == '0'){
                if(flag == true){
                    if(i == word.length() - 1){
                        right = word.length();
                        if(right > left){
                            if(!list.contains(word.substring(left,right))){
                                list.add(word.substring(left,right));
                            }
                        }
                    }
                    else
                        i++;
                }
                else if(i == word.length() - 1){
                    zero = 1;
                    i++;
                }
                else if(word.charAt(i + 1) >= 'a' && word.charAt(i + 1) <= 'z' ){
                    zero = 1;
                    i++;
                }
                else
                    i++;
            }
            else if((word.charAt(i) >= 'a' && word.charAt(i) <= 'z')){
                if(flag == true){
                    flag = false;
                    right = i;
                    i++;
                }
                else{
                    i++;
                }
                if(right > left){
                        if(!list.contains(word.substring(left,right))){
                            list.add(word.substring(left,right));
                        }
                }
            }
            else if(word.charAt(i) >= '1' && word.charAt(i) <= '9'){
                if(flag == true && i == word.length() - 1){
                    right = word.length();
                    if(right > left){
                        if(!list.contains(word.substring(left,right))){
                            list.add(word.substring(left,right));
                        }
                    }
                }
                if(flag == false){
                    if(i == word.length() - 1){
                        if(!list.contains(word.charAt(i)+""))
                            list.add(word.charAt(i)+"");
                    }
                    flag = true;
                    left = i;
                    i++;
                }
                else{
                    i++;
                }
            }
        }
        return list.size() + zero;
    }
}
