package Leetcode;

import java.util.*;

public class leetcode187 {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> res = findRepeatedDnaSequences(s);
        System.out.println(res.toString());

    }

    public static List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        List<String> res = new ArrayList<>();
        Map<String,Integer> map = new HashMap<>();
        if(len < 10) return res;
        len = len - 10;
        for(int i = 0;i <= len;i++){
            String key = s.substring(i,i + 10);
            int value = map.getOrDefault(key,0);
            if(value == 1) res.add(key);
            map.put(key,value + 1);
        }
        return res;
    }
}
