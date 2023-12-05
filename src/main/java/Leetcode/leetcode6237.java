package Leetcode;

import java.util.Arrays;

public class leetcode6237 {
    public static void main(String[] args) {
        int []nums = {9,5,7,8,7,9,8,2,0,7};
        System.out.print(distinctAverages(nums));

    }
    public static int distinctAverages(int[] nums) {
        Arrays.sort(nums);
        int i,j = nums.length - 1;
        double k;
        double []a = new double[nums.length / 2];
        int count = 1;
        for(i = 0;i < nums.length / 2;i++){
            k = ((double)(nums[i] + nums[j])) / 2;
            a[i] = k;
            j--;
        }
        Arrays.sort(a);
        for(i = 0;i < a.length - 1;i++){
            if(a[i] != a[i + 1])
                count++;
        }
        return count;
    }
}
