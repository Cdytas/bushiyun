package Leetcode;

public class leetcode69 {
    public static void main(String[] args) {
        //System.out.print(mySqrt(Integer.MAX_VALUE));
        System.out.print(46341*46341);
    }

    public static int mySqrt(int x) {
        int temp = x;
        int n = 1;
        while(temp != 0){
            temp = temp / 100;
            n = n * 10;
        }
        int m = n / 10;
        for(int i = m;i <= n;i++){
            long sum1 = i * i;
            long sum2 = (i + 1) * (i + 1);
            if(sum1 == x || (sum1 < x && x < sum2))
                return i;
        }
        return -1;
    }
}
