package com.barca.bushiyun.util;

/**
 * ST 表（Sparse Table）- 用于解决 RMQ（区间最值查询）问题
 * 支持 O(1) 时间复杂度查询任意区间的最大值和最小值
 * 预处理时间复杂度：O(n log n)
 * 查询时间复杂度：O(1)
 * 空间复杂度：O(n log n)
 */
public class St {
    private final int[][] stMax;
    private final int[][] stMin;
    private final int[] log;
    /**
     * 构造函数：构建 ST 表
     * @param nums 原始数组
     */
    public St(int[] nums) {
        int n = nums.length;

        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        int k = log[n] + 1;
        stMax = new int[n][k];
        stMin = new int[n][k];
        for (int i = 0; i < n; i++) {
            stMax[i][0] = nums[i];
            stMin[i][0] = nums[i];
        }

        for (int j = 1; j < k; j++) {
            for (int i = 0; i + (1 << j) <= n; i++) {
                stMax[i][j] = Math.max(stMax[i][j - 1], stMax[i + (1 << (j - 1))][j - 1]);
                stMin[i][j] = Math.min(stMin[i][j - 1], stMin[i + (1 << (j - 1))][j - 1]);
            }
        }
    }

    /**
     * 查询区间 [l, r] 的最大值 (包含 l 和 r)
     * @param l 左边界 (0-indexed)
     * @param r 右边界 (0-indexed)
     * @return 区间最大值
     */
    public int getMax(int l, int r) {
        int len = r - l + 1;
        int j = log[len]; // 也就是 floor(log2(len))

        // 利用两个长度为 2^j 的区间覆盖 [l, r]
        // 区间1: [l, l + 2^j - 1]
        // 区间2: [r - 2^j + 1, r]
        return Math.max(stMax[l][j], stMax[r - (1 << j) + 1][j]);
    }

    /**
     * 查询区间 [l, r] 的最小值 (包含 l 和 r)
     * @param l 左边界 (0-indexed)
     * @param r 右边界 (0-indexed)
     * @return 区间最小值
     */
    public int getMin(int l, int r) {
        int len = r - l + 1;
        int j = log[len];

        return Math.min(stMin[l][j], stMin[r - (1 << j) + 1][j]);
    }
}
