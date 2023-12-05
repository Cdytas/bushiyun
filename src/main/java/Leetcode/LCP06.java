package Leetcode;

public class LCP06 {
    public static void main(String[] args) {
        int a[] = {4,2,1};
        System.out.print(minCount(a));
    }
    public static int minCount(int[] coins) {
        int i,count = 0;
        for(i = 0;i < coins.length;i++){
            while(coins[i] > 0){
                coins[i] = coins[i] - 2;
                count++;
            }
        }
        return count;
    }
}
