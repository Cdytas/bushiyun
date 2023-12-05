package Leetcode;

public class leetcode400 {
    public static void main(String[] args) {
        System.out.print(findNthDigit(1000000000));
    }

    public static int findNthDigit(int n) {
        if(n < 10) return n;
        int wei = 2;
        long count = 90;
        long sup = n - 10;
        while(sup >= 0){
            sup = sup - wei * count;
            wei++;
            count = count * 10;
        }
        wei = wei - 1;
        count = count / 10;
        sup = sup + wei * count;
        int geshu = (int)sup / wei;
        int yushu = (int)sup % wei;
        int number;
        if(geshu == 0) number = (int)Math.pow(10,wei - 1);
        else number = (int)Math.pow(10,wei - 1) + geshu;
        String str = number + "";
        return str.charAt(yushu) - '0';
    }
}
