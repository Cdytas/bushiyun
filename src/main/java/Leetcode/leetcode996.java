package Leetcode;
import java.util.*;
public class leetcode996 {

    int[][] memo;
    int[] nums;

    public static void main(String[] args) {
        leetcode996 exec = new leetcode996();
        int[] nums = {1,17,8};
        System.out.print(exec.numSquarefulPerms(nums));
    }
    public int numSquarefulPerms(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return check(nums[0]) ? 1 : 0;
        }
        this.nums = nums;
        memo = new int[1 << 12][n];
        for (int i = 0; i < 1 << 12; i++) {
            Arrays.fill(memo[i], -1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (!map.containsKey(nums[i])) {  //去重
                map.put(nums[i], 1);
                res += f(1, 1 << i, i);
            }
        }
        return res;
    }

    public int f(int index, int mask, int preIndex) {
        if (index == nums.length) {  //获得一种有效排列
            return 1;
        }
        if (memo[mask][preIndex] != -1) {  //已计算过这种情况
            return memo[mask][preIndex];
        }
        Map<Integer, Integer> map = new HashMap<>(); //层级锁，保证不重复
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i]) && (mask >> i & 1) == 0 && check(nums[i] + nums[preIndex])) {
                map.put(nums[i], 1);  //上锁
                res += f(index + 1, mask | (1 << i), i);
            }
        }
        memo[mask][preIndex] = res;
        return res;
    }

    private boolean check(int num) {
        int a = (int)Math.sqrt(num);
        return a * a == num;
    }
}
