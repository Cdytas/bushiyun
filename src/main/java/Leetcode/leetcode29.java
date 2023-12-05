package Leetcode;
import java.util.Scanner;
public class leetcode29 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("请输入两个整数：");
        int dividend = input.nextInt();
        int divisor = input.nextInt();
        System.out.print("相除结果为: "+divide(dividend,divisor));
    }
    public static int divide(int dividend, int divisor) {
        int sign = 0;
        if((dividend > 0  && divisor > 0) || (dividend < 0  && divisor < 0))
            sign = 1;
        else if((dividend > 0  && divisor < 0) || (dividend < 0  && divisor > 0))
            sign = -1;
        if(dividend == Integer.MIN_VALUE  &&  divisor == -1)
            return Integer.MAX_VALUE;
        else if(dividend == Integer.MIN_VALUE  &&  divisor == 1)
            return Integer.MIN_VALUE;
        if(divisor == Integer.MIN_VALUE && dividend == Integer.MIN_VALUE)
            return 1;
        else if(divisor == Integer.MIN_VALUE)
            return 0;
        int dend;
        int result = 0;
        if(dividend == Integer.MIN_VALUE  && Math.abs(divisor) != 1){
            if(divisor > 0)
                dend = Math.abs(dividend + divisor);
            else
                dend = Math.abs(dividend + Math.abs(divisor));
            result++;
        }
        else {
            dend = Math.abs(dividend);
        }
        int sor = Math.abs(divisor);
        if(dend < sor && sign == 1)
            return result;
        else if(dend < sor && sign == -1)
            return -result;
        if(sor == 1 && sign == 1)
            return dend;
        else if(sor == 1 && sign == -1)
            return -dend ;
        while(dend >= sor){
            dend = dend - sor;
            result ++;
        }
        if(sign == 1)
            return result;
        else
            return -result;
    }
}
