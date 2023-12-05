package Leetcode;

import java.util.*;

public class leetcode6357 {
    public static void main(String[] args) {
        int[] nums = {3,1,6,8};
        int[] queries = {1,5,7};
        List<Long> res = minOperations(nums, queries);
        for (long x : res) {
            System.out.print(x + " ");
        }
    }

    public static List<Long> minOperations(int[] nums, int[] queries) {
        List<Long> res = new ArrayList<>();
        Map<Integer,Long> map = new HashMap<>();
        long sum = 0;
        for (int i = 0; i < queries.length; i++) {
            int key = queries[i];
            if (map.containsKey(key)) {
                res.add(map.get(key));
                continue;
            }
            for (int j = 0; j < nums.length; j++) {
                sum += Math.abs(nums[j] - key);
            }
            map.put(key,sum);
            res.add(sum);
            sum = 0;
        }
        return res;
    }
}
