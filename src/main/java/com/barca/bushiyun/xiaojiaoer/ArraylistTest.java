package com.barca.bushiyun.xiaojiaoer;

import java.util.ArrayList;
import java.util.List;

public class ArraylistTest {
    public static void main(String[] args) {
        System.out.println(Math.pow(26,0));
        System.out.println(swit(3679));
        List<List<Integer>> list1 = new ArrayList<List<Integer>>();
        List<Integer> list2 = new ArrayList<>();
        for(int i = 0; i < 10;i++){
            list2.add(i);
        }
        list1.add(list2);
        System.out.print(list1);
    }

    public static int swit(int n){
        int sum = 0;
        while(n != 0){
            sum += n % 10;
            n = n / 10;
        }
        return sum;
    }


}
