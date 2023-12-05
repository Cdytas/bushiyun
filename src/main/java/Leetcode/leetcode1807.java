package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode1807 {
    public static void main(String[] args) {
        String s = "(name)is(age)yearsold(kkkk)";
        List<List<String>> knowledge = new ArrayList<>();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("name");
        list1.add("bob");
        list2.add("age");
        list2.add("two");
        knowledge.add(list1);
        knowledge.add(list2);
        String str = evaluate(s,knowledge);
        System.out.print(str);

    }


    public static String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder str = new StringBuilder();
        StringBuilder key = new StringBuilder();
        Map<String,String> map = new HashMap<>();
        for(List<String> t : knowledge){
            map.put(t.get(0),t.get(1));
        }
        boolean flag = false;
        int i = 0;
        while(i < s.length()){
            if(s.charAt(i) >= 'a' && s.charAt(i) <= 'z'){
                if(flag == false){                //还未开启key的记录
                    str.append(s.charAt(i));
                    i++;
                }
                else{                              //已经开始记录key
                    key.append(s.charAt(i));
                    i++;
                }
            }
            else if(s.charAt(i) == '('){
                flag = true;
                i++;
            }
            else{
                flag = false;
                String str2 = value(key.toString(),map);
                str.append(str2);
                key.delete(0,key.length());
                i++;
            }
        }
        return str.toString();
    }

    public static String value(String key,Map<String,String> map){
        String str = "?";
        if(map.containsKey(key))
            str = map.get(key);
        return str;
    }
}
