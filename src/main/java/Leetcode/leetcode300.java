package Leetcode;

public class leetcode300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.print(lengthOfLIS(nums));
    }
    public static  int lengthOfLIS(int[] nums) {
        int[] f = new int[nums.length];
        for(int i = 0;i < f.length;i++)
            f[i] = 1;
        for(int i = 1;i < nums.length;i++)
            for(int j = 0;j < i;j++)
                if(nums[j] < nums[i]) f[i] = Math.max(f[i],f[j] + 1);
        int max = f[0];
        for(int i = 1;i < f.length;i++)
            max = Math.max(max,f[i]);
        return max;
    }
}
