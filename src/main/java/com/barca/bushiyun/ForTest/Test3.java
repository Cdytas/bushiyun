package com.barca.bushiyun.ForTest;

import java.util.*;

public class Test3 {
    public static void main(String[] args) {
        String[] strs = {"10:00","10:40","11:00","09:00","11:00"};
        Map<String, List<String>> map = new HashMap<>();
        map.put("1",new ArrayList<>());
        map.put("2",new ArrayList<>());
        map.put("3",new ArrayList<>());
        map.put("4",new ArrayList<>());
        Set<String> set = map.keySet();
        Iterator it = set.iterator();
        while(it.hasNext()){
            String s = (String)it.next();
            System.out.println(it.next());
        }
        Arrays.sort(strs);
        for(String s : strs)
            System.out.println(s);
    }
}
