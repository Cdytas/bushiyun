package com.barca.bushiyun.xiaojiaoer;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入年份：");
        int n = input.nextInt();
        boolean flag = LeapYear(n);
        if(flag == true){
            System.out.print(n + "年是闰年");
        }
        else{
            System.out.print(n + "年不是闰年");
        }
    }

    public static boolean LeapYear(int year){
        if(year % 4 == 0){
            if(year % 400 == 0){
                return true;
            }
            else if(year % 100 == 0){
                return false;
            }
            else {
                return true;
            }
        }
        else{
            return false;
        }
    }
}
