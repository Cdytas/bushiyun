package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class leetcode1681 {
    private int[] memo, nums;
    private int n, m;
    private Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        leetcode1681 exec = new leetcode1681();
        int[] nums = {1,2,1,4};
        int res = exec.minimumIncompatibility(nums, 2);
        System.out.print(res);
    }
    public int minimumIncompatibility(int[] nums, int k) {
        this.n = nums.length;
        this.nums = nums;
        m = n / k;  //单个集合的长度
        memo = new int[1 << n];
        Arrays.fill(memo, -1);   //memo[i]表示未划分的下标集合为i时，得到的最小不兼容性和
        return f((1 << n) - 1) == 300 ? -1 : memo[(1 << n) - 1];
    }

    private int f(int i) {
        if (i == 0) {  //集合为空
            return 0;
        }
        if (memo[i] != -1) {  //已计算过
            return memo[i];
        }
        int res = 300;
        for (int j = i; j > 0; j = (j - 1) & i) {  //枚举i的子集j
            int cnt = Integer.bitCount(j);
            if (cnt != m) {
                continue;
            }
            int val;
            if (map.containsKey(j)) {
                val = map.get(j);
            }
            else {
                val = check(j);
            }
            if (val != -1) {
                res = Math.min(res, val + f(i ^ j));
            }
        }
        return memo[i] = res;
    }

    private int check(int j) {
        int min = 17;
        int max = 0;
        int res = -1;
        Map<Integer, Integer> map2 = new HashMap<>();
        boolean flag = true;
        for (int i = 0; i < n; i++) {
            if ((j >> i & 1) == 1) {
                if (map2.containsKey(nums[i])) {  //有重复
                    flag = false;
                    break;
                }
                else {
                    min = Math.min(min, nums[i]);
                    max = Math.max(max, nums[i]);
                    map2.put(nums[i], 1);
                }
            }
        }
        if (flag) {
            res = max - min;
        }
        map.put(j, res);
        return res;
    }
}
