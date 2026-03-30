package com.barca.bushiyun.util;

/**
 * ST 表（Sparse Table）- 用于解决 RMQ（区间最值查询）问题
 * 支持 O(1) 时间复杂度查询任意区间的最大值和最小值
 * 预处理时间复杂度：O(n log n)
 * 查询时间复杂度：O(1)
 * 空间复杂度：O(n log n)
 */
public class St {
    // stMax[j][i] 表示从索引 i 开始，长度为 2^j 的区间内的最大值
    private final int[][] stMax;
    // stMin[j][i] 表示从索引 i 开始，长度为 2^j 的区间内的最小值
    private final int[][] stMin;
    // log[i] 存储 floor(log2(i))，用于加速查询
    private final int[] log;

    /**
     * 构造函数：构建 ST 表
     * @param nums 原始数组
     */
    public St(int[] nums) {
        int n = nums.length;

        // 1. 预处理 log 数组
        // log[i] = floor(log2(i))
        log = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            log[i] = log[i / 2] + 1;
        }

        // 计算最大层数 k
        int k = log[n] + 1;

        // 初始化表
        stMax = new int[k][n];
        stMin = new int[k][n];

        // 第 0 层：长度为 1 的区间，值即为原数组元素
        for (int i = 0; i < n; i++) {
            stMax[0][i] = nums[i];
            stMin[0][i] = nums[i];
        }

        // 动态规划构建表格
        // j 代表区间幂次长度 2^j
        for (int j = 1; j < k; j++) {
            // i 代表起始位置，需保证区间不越界
            for (int i = 0; i + (1 << j) <= n; i++) {
                int mid = i + (1 << (j - 1));
                // 状态转移：当前区间 = 左右两个子区间的合并
                stMax[j][i] = Math.max(stMax[j - 1][i], stMax[j - 1][mid]);
                stMin[j][i] = Math.min(stMin[j - 1][i], stMin[j - 1][mid]);
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
        return Math.max(stMax[j][l], stMax[j][r - (1 << j) + 1]);
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

        return Math.min(stMin[j][l], stMin[j][r - (1 << j) + 1]);
    }
}
