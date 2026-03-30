package com.barca.bushiyun.ForTest;


import java.util.*;

public class Test8 {

    public static void main(String[] args) {
        int[] c = {1000000000,1000000000,1000000000};
        System.out.println(new Test8().numGoodSubarrays(c, 1000000000));

    }



    public long numGoodSubarrays(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        Map<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);

        long preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            int m = (int)preSum % k;
            int cnt = memo.getOrDefault(m, 0);
            res += cnt;
            memo.put(m, cnt + 1);
        }

        int i = 0;
        while (i < n) {
            if (k % nums[i] != 0) {
                i++;
                continue;
            }

            int j = i + 1;
            while (j < n && nums[j] == nums[j - 1]) {
                j++;
            }

            int cnt = j - i;
            int minCnt = k / nums[i];
            int actCnt = minCnt;

            while (actCnt <= cnt) {
                res -= cnt - actCnt;
                actCnt += minCnt;
            }

            i = j;
        }

        return res;
    }

}

