package Leetcode;

public class leetcode2507 {
    public static void main(String[] args) {
        System.out.println(smallestValue(32));
    }

    public static int smallestValue(int n){
        if(zhishu(n))
            return n;
        for(int i = (int)(Math.sqrt(n));i >= 2;i--){
            if(!zhishu(i))
                continue;
            int j = n / i;
            if(i * j != n)
                continue;
            if(!(zhishu(j))){
                j = small( j);
                return smallestValue(i + j);
            }
            else
                return smallestValue(i + j);
        }
        return -1;
    }

    public static int small(int n) {
        if(zhishu(n))
            return n;
        int i ;
        int j  = 0;
        for(i = (int)(Math.sqrt(n));i >= 2;i--){
            if(!zhishu(i))
                continue;
            j = n / i;
            if(i * j != n)
                continue;
            if(!(zhishu(j))){
                j = small( j);
                break;
            }
            else
                return i + j;
        }
        return i + j;
    }

    public static boolean zhishu(int n){
        if(n == 2)
            return true;
        for(int i = 2;i <= (int)Math.sqrt(n);i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
