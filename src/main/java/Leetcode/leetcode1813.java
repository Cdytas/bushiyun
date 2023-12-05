package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode1813 {
    public static void main(String[] args){

    String sentence1 = "of";
    String sentence2 = "My of Haley";
    System.out.println(areSentencesSimilar(sentence1,sentence2));
}


    public static boolean areSentencesSimilar(String sentence1, String sentence2) {
        List<String> str1 = new ArrayList<>();
        List<String> str2 = new ArrayList<>();
        int start = 0;
        int i = 0;
        while(start < sentence1.length() && i < sentence1.length()){
            if(sentence1.charAt(i) != ' '){
                i++;
                if(i == sentence1.length()) {
                    str1.add(sentence1.substring(start, i));
                    break;
                }
            }
            else{
                str1.add(sentence1.substring(start,i));
                start = i + 1;
                i++;
            }
        }
        start = 0;
        i  = 0;
        while(start < sentence2.length() && i < sentence2.length()){
            if(sentence2.charAt(i) != ' '){
                i++;
                if(i == sentence2.length()) {
                    str2.add(sentence2.substring(start, i));
                    break;
                }
            }
            else{
                str2.add(sentence2.substring(start,i));
                start = i + 1;
                i++;
            }
        }
        if(str1.size() == 1){
            if(str1.get(0).equals(str2.get(0)) || str1.get(0).equals(str2.get(str2.size() - 1)))
                return true;
            return false;
        }
        if(str2.size() == 1){
            if(str2.get(0).equals(str1.get(0)) || str2.get(0).equals(str1.get(str1.size() - 1)))
                return true;
            return false;
        }
        if(str1.get(0).equals(str2.get(0)) && str1.get(str1.size() - 1).equals(str2.get(str2.size() - 1)))
            return true;
        return false;
    }
}
