package Leetcode;

public class leetcode122 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.print(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int res = 0;
        int buy = 0;
        int len = prices.length;
        boolean flag = false; //手中是否持有股票
        for (int i = 0; i < len - 1; i++) {
            if (prices[i] >= prices[i + 1]) {
                if (flag == false) {
                    continue;  //手中无股票，继续寻找更便宜的价格
                }
                else {
                    res += prices[i] - buy;  //已到达某个波峰，股票卖掉
                    flag = false;
                }
            }
            else {
                if (flag == false) {
                    buy = prices[i];  //到达某个波谷，购入股票
                    flag = true;
                }  //手中有股票的话就继续寻找更高价格
            }
        }
        if (flag && prices[len - 1] > buy) {
            res += prices[len - 1] - buy;
        }
        return res;
    }
}
