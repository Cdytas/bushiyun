package Leetcode;

import java.util.*;

public class leetcode1814 {
    public static void main(String[] args) {
        int[] nums = {13,10,35,24,76};
        System.out.println(countNicePairs(nums));
    }

    public static int countNicePairs(int[] nums) {
        final int mod =(int) 1e9 + 7;
        Map<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 0;i < nums.length;i++){
            int temp = reverse(nums[i]) - nums[i];
            sum = (sum + map.getOrDefault(temp,0)) % mod;
            map.put(temp,map.getOrDefault(temp,0) + 1);
            }
        return sum;
    }
    public static int reverse(int n){
        int sum = 0;
        while(n != 0){
            int temp = n % 10;
            n = n / 10;
            sum = sum * 10 + temp;   // 霍纳算法
        }
        return sum;
    }
}
