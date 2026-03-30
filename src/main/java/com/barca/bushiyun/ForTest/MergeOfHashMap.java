package com.barca.bushiyun.ForTest;

import java.util.HashMap;
import java.util.Map;

public class MergeOfHashMap {
    public static void main(String[] args) {
        Map<Integer, Integer> memo1 = new HashMap<>();
        Map<Integer, Integer> memo2 = new HashMap<>();
        memo1.put(1,2);
        memo1.put(2,4);
        memo1.put(3,6);
        memo2.put(1,3);
        memo2.put(2,6);
        memo2.forEach((key, val) -> {   //将memo2的键值对合并到memo1中。只合并同样存在的键，合并的方式由自己决定
            memo1.merge(key, val, (v1, v2) -> v1 * v2);  //前两个参数为尝试合并进来的新的键值对，后面的自定义函数的参数为相同键（若存在）所对应的两个不同值
        });
        for (Map.Entry<Integer, Integer> m : memo1.entrySet()) {
            int key = m.getKey();
            int val = m.getValue();
            System.out.println(key + " " + val);
        }

    }
}
