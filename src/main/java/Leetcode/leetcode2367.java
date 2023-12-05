package Leetcode;

public class leetcode2367 {
    public static void main(String[] args) {
        int[] nums = {0,1,4,6,7,10};
        System.out.println(arithmeticTriplets(nums, 3));

    }

    public static int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        int mid = 1;
        int right = nums.length - 1;
        for (int left = 0; left < nums.length - 2; left++) {
            while (nums[mid] - nums[left] < diff) {
                mid++;
                if (mid == nums.length - 1) {
                    return res;
                }
            } //mid查找完毕
            if (nums[mid] - nums[left] > diff || nums[right] - nums[mid] < diff) {
                continue;
            }
            while (nums[right] - nums[mid] > diff) {
                right--;
            } //right查找完毕
            if (nums[right] - nums[mid] < diff) {
                continue;
            }
            res++;
            right = nums.length - 1;
        }
        return res;
    }
}
