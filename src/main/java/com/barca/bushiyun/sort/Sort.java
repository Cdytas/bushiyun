package com.barca.bushiyun.sort;

public class Sort {
    public static void ExchangeForInt(int[] a, int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void ExchangeForChar(char[] a, int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T> void ExchangeForClass(T[] a,int i,int j){
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static  boolean Less(Comparable i,Comparable j){
        if (i == null || j == null) {
            throw new NullPointerException();
        }
        return i.compareTo(j) < 0;
    }

}
