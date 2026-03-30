package com.barca.bushiyun.ForTest;

public class StringMethodTest {

    public static void main(String[] args) {
        char[] c = {'a', 'b', 'c', 'd', 'x', 'y', 'z'};
        String s1 = String.valueOf(c);
        String s2 = String.valueOf(c,0,7); //第一个int型参数表示从字符串选取的起始下标，第二个int参数表示选取个数，过长会报错
        String s3 = new String(c);
        String s4 = c.toString();
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s3);
        System.out.println(s4);
        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
    }
}
