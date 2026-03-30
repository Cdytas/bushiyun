package com.barca.bushiyun.util;

public class St {

    private int k;
    private int[][] minK;
    private int[][] maxK;

    public St(int[] nums) {
        int n = nums.length;
        this.k = (int) Math.ceil(Math.log(n) / Math.log(2));
        this.minK = new int[n][k];
        this.maxK = new int[n][k];
        for (int i = 0; i < n; i++) {
            minK[i][0] = nums[i];
            maxK[i][0] = nums[i];
        }
    }


}
