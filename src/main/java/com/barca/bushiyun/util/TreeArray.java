package com.barca.bushiyun.util;

public class TreeArray {
    private int[] tree;
    private int[] A;
    private int n;

    public TreeArray(int[] nums) {
        this.n = nums.length;
        this.A =  new int[n + 1];
        this.tree = new int[n + 1];  //构建管控数组，下标从 1 ~ n
        for (int i = 0; i < n; i++) {
            A[i + 1] = nums[i];  //A是被管控的数组，下标也从1 ~ n,这样方便理解
        }
    }

    public void initialize() {
        for (int i = 1; i <= n; i++) {
            add(i, A[i]);   //管控数组下标从1开始
        }
    }

    public int lowbit(int m) {
        return m & -m;
    }

    public int query(int x) {  //查询前x个元素的和
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tree[i];
        }
        return res;
    }

    public void add(int i, int u) {  //nums[i]若增加u，tree数组中所有管控nums[i]的值也要相应增加
        for (int j = i; j <= n; j += lowbit(j)) {
            tree[j] += u;
        }
    }
}
