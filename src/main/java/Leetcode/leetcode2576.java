package Leetcode;

import java.util.Arrays;

public class leetcode2576 {
    public static void main(String[] args) {
        int[] nums = {3,5,2,4};
        System.out.println(maxNumOfMarkedIndices(nums));
    }


    public static int maxNumOfMarkedIndices(int[] nums) {
        int res = 0;
        int high = nums.length;
        if(high == 1) return 0;
        Arrays.sort(nums);
        int low = high / 2 - 1;
        high--;
        while(low >= 0 && high >= nums.length / 2){
            if(nums[low] * 2 <= nums[high]){
                low--;
                high--;
                res++;
            }
            else{
                low--;
            }
        }
        return 2 * res;
    }
}
