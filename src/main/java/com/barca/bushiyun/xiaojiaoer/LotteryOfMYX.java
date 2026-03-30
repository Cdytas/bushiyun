package com.barca.bushiyun.xiaojiaoer;

import java.util.Scanner;

public class LotteryOfMYX {
    public static void main(String[] args) {
        int number = (int)(Math.random() * 90000 + 10000);
        Scanner input = new Scanner(System.in);
        String str[] = new String[3];
        boolean flag = false;
        System.out.print("请输入三个购买的号码：");
        for(int i = 0;i < 3;i++){
            str[i] = input.nextLine();
        }

        for(int i = 0;i < 3;i++){
            if(str[i].equals("90300"))
                System.out.println("恭喜您触发毛意鑫影藏大奖，隐藏号码为" + 90300 + "," + "中奖金额："+100000000);
            int count = lottery(str[i],number);
            if(count > 0)
            {
                flag = true;
                System.out.println("恭喜您中得毛意鑫大奖，彩票号码为" + number + ",中奖彩票号码为：" + str[i] + ",中奖号码个数为："+count + ",中奖金额："+Math.pow(10,count - 1));
            }
        }
        if(flag == false)
            System.out.print("很遗憾您没中奖！彩票号码为：" + number );
    }

    public static int lottery(String str,int number){
        String str2 = NumberToString(number);
        if(str.length() != str2.length())
            return 0;
        int count =0 ;
        int[] a = new int[10];
        int[] b = new int[10];
        for(int i = 0;i < str.length();i++){
            a[(str.charAt(i) - '0')]++;
            b[(str2.charAt(i) - '0')]++;
        }
        for(int i = 0;i < 10;i++){
            if(a[i] > 0 && b[i] > 0){
                count += a[i] <= b[i] ? a[i] : b[i];
            }
        }
        return count;
    }

    public static String NumberToString(int n){
        if(n == 0)
            return "";
        else
            return "" + NumberToString(n / 10) + (n % 10);
    }
}
