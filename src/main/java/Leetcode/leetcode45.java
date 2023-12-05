package Leetcode;

public class leetcode45 {
    public static void main(String[] args) {
        int[] nums = {4,1,1,3,1,1,1};
        System.out.print(jump(nums));
    }

    public static int jump(int[] nums) {
        if(nums.length == 1)
            return 0;
        int i = 0;
        int k = 0,max;
        int count = 0;
        while(i < nums.length){
            if(i + nums[i] >= nums.length - 1)
                return count + 1;
            k = i + 1;
            max = nums[i + 1] + i + 1;
            for(int j = i + 1;j <= i + nums[i];j++){
                if(nums[j]  + j  > max){
                    max = nums[j] + j;
                    k = j;
                }
            }
            i = k;
            count++;
            if(i >= nums.length - 1){
                return count;
            }
        }
        return count;
    }
}
