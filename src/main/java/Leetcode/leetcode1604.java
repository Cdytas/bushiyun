package Leetcode;

import java.util.*;

public class leetcode1604 {
    public static void main(String[] args) {
        String[] keyName =  {"daniel","daniel","daniel","luis","luis","luis","luis"};
        String[] keyTime = {"10:00","10:40","11:00","09:00","11:00","13:00","15:00"};
        List<String> res = alertNames(keyName,keyTime);
        for(String s : res)
            System.out.print(s);
    }


    public static List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String,List<String>> map = new HashMap<>();
        List<String> res = new ArrayList<>();
        for(int i = 0;i < keyName.length;i++){
            if(!map.containsKey(keyName[i])){
                List<String> list = new ArrayList<>();
                list.add(keyTime[i]);
                map.put(keyName[i],list);
            }
            else{
                List<String> list = map.get(keyName[i]);
                list.add(keyTime[i]);
            }
        }
        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        int[] a;
        int time;
        while(it.hasNext()){
            String str = it.next();
            List<String> list = map.get(str);
            a = new int[24];
            for(int i = 0;i < list.size();i++){
                String s = list.get(i);
                time = (s.charAt(0) - '0') * 10 + s.charAt(1) - '0';
                if(s.charAt(3) == '0' && s.charAt(4) == '0'){
                    if(time == 0){
                        a[0]++;
                        a[23]++;
                    }
                    else{
                        a[time]++;
                        a[time - 1]++;
                    }
                }
                else{
                    a[time]++;
                }
            }
            for(int i = 0;i < 24;i++){
                if(a[i] >= 3){
                    res.add(str);
                    break;
                }
            }
        }
        return res;
    }
}
