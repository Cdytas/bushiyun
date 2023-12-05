package Leetcode;

public class leetcode2106 {
    public static void main(String[] args) {
        int[][] fruits = {{0,7},{7,4},{9,10},{12,6},{14,8},{16,5},{17,8},{19,4},{20,1},{21,3},{24,3},{25,3},{26,1},{28,10},{30,9},{31,6},{32,1},{37,5},{40,9}};
        System.out.print(maxTotalFruits(fruits, 21, 30));

    }


    public static int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int max = fruits[fruits.length - 1][0];  //有果实的最大下标
        int min = fruits[0][0];   //有果实的最小下标
        int res = 0;
        int[] memo = new int[max + 1];
        for (int i = 0; i < fruits.length; i++) {
            memo[fruits[i][0]] = fruits[i][1];
        }
        if (k == 0) {
            if (startPos >= min && startPos <= max) {
                return memo[startPos]; //只能摘到原地的果实喽
            }
            return 0;  //一个也没有
        }
        int[] sum = new int[max + 2];
        for (int i = 1; i <= max + 1; i++) {
            sum[i] = sum[i - 1] + memo[i - 1];
        }
        if (startPos <= min) {
            if (startPos + k >= max) {
                return sum[max + 1];
            }
            return sum[startPos + k + 1];
        }
        else if (startPos >= max) {
            if (startPos - k > max) {
                return 0;
            }
            return sum[max + 1] - sum[startPos - k];
        }
        int disOfmin = startPos - min;
        int disOfmax = max - startPos;
        if (k >= 2 * disOfmin + disOfmax || k >= 2 * disOfmax + disOfmin) {
            return sum[max + 1];
        }
        int remain;
        int left;
        int right;
        for (int i = 1; i <= disOfmin && i <= k; i++) {  //先往左走，初始right为startPos
            remain = k;
            right = startPos;
            left = startPos - i;
            remain -= i;
            if (remain >= max - left) {
                right = max;
                remain -= max - left;
            }
            else {
                right = Math.max(right, left + remain); //取原先的right和从左往右走的较大值
                remain = 0;
            }
            if (remain != 0) {
                left = Math.min(left, max - remain); //或许还可以往左移动
            }
            res = Math.max(res, sum[right + 1] - sum[left]);
        }
        for (int i = 1; i <= disOfmax && i <= k; i++) {
            remain = k;
            left = startPos;
            right = startPos + i;
            remain -= i;
            if (remain >= right - min) {
                left = min;
                remain -= right - min;
            }
            else {
                left = Math.min(left, right - remain);
                remain = 0;
            }
            if (remain != 0) {
                right = Math.max(right, min + remain);
            }
            res = Math.max(res, sum[right + 1] - sum[left]);
        }
        return res;
    }
}
