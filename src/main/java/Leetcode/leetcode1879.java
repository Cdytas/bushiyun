package Leetcode;
import java.util.*;
public class leetcode1879 {

    int[][] memo;
    int n;
    int[] nums1, nums2;

    public static void main(String[] args) {
        leetcode1879 exec = new leetcode1879();
        int[] nums1 = {1,2}, nums2 = {2,3};
        int res = exec.minimumXORSum(nums1, nums2);
        System.out.print(res);
    }
    public int minimumXORSum(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;
        n = nums1.length;
        memo = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(n - 1, 0);
    }

    private int dfs(int i, int mask) {
        if (memo[i][mask] != -1) {
            return memo[i][mask];
        }
        if (i == 0) {
            for (int d = 0; d < n; d++) {
                if ((mask >> d & 1) == 0) {
                    return memo[0][mask] = nums1[0] ^ nums2[d];
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (int d = 0; d < n; d++) {
            if ((mask >> d & 1) == 0) {
                res = Math.min(res, (nums1[i] ^ nums2[d]) + dfs(i - 1, mask | (1 << d)));
            }
        }
        return memo[i][mask] = res;
    }
}
