package com.barca.bushiyun.ForTest;
import com.barca.bushiyun.sort.Sort;

public class Test1 {
    public static void main(String[] args) {
        int[] a = {1,2};
        String[] b = {"adasdas","ggggg"};
        char[] c = {'c','d'};
        System.out.println(a[0] + "  "+b[0] + "  " + c[0]);
        Sort.ExchangeForInt(a,0,1);
        Sort.ExchangeForClass(b,0,1);
        Sort.ExchangeForChar(c,0,1);
        System.out.println(a[0] + "  "+b[0] + "  " + c[0]);
        System.out.print(Sort.Less(a[0],a[1]));

    }
}
