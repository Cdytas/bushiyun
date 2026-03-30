package com.barca.bushiyun.ForTest;

public class Test2 {
    public static void main(String[] args) {
        int[] a = {1,3,5,7,9};
        int[] b = {2,4,6,8,10};
        int[] c;
        swit(a,b);
        for(int x : b)
            System.out.print(x + " ");
        System.out.println();
        for(int x : a)
            System.out.print(x + " ");

    }

    public static void swit(int[] a,int[] b){
        int[] c = a;
        a = b;
        b = c;
        b[0] = 100;
    }





}
