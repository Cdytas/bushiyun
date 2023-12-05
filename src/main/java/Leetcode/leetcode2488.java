package Leetcode;


import java.util.*;

public class leetcode2488 {
    public static void main(String[] args) {
        int[] nums = {2,5,1,4,3,6};
        System.out.println(countSubarrays(nums, 1));

    }
    public static int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        if (n == 1 || k == n) {
            return 1;
        }
        Map<Integer,Integer> left = new HashMap<>();
        Map<Integer,Integer> right = new HashMap<>();
        int countOfBig = 0;
        int countOfSmall = 0 ;
        int index = -1;
        int res = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                index = i;
                break;
            }
        }
        for (int i = index - 1; i >= 0; i--) {
            if (nums[i] < k) {
                countOfSmall++;
            }
            else {
                countOfBig++;
            }
            int key = countOfSmall - countOfBig;
            int value = left.getOrDefault(key,0);
            left.put(key,value + 1);
        }
        countOfSmall = 0;
        countOfBig = 0;
        for (int i = index + 1; i < nums.length; i++) {
            if (nums[i] > k) {
                countOfBig++;
            }
            else {
                countOfSmall++;
            }
            int key = countOfBig - countOfSmall;
            int value = right.getOrDefault(key,0);
            right.put(key,value + 1);
        }
        Set<Integer> set = left.keySet();
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()){
            int key = it.next();
            int value = left.get(key);
            int value2 = right.getOrDefault(key,0);
            int value3 = right.getOrDefault(key + 1,0);
            res += value * (value2 + value3);
            if (key == -1 || key == 0) {
                res += value;
            }
        }
        set = right.keySet();
        it = set.iterator();
        while(it.hasNext()){
            int key = it.next();
            int value = right.get(key);
            if (key == 0 || key == 1) {
                res += value;
            }
        }
        return res;
    }
}
