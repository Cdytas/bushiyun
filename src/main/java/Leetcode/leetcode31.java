package Leetcode;

public class leetcode31 {
    public static void main(String[] args) {
        int[] nums = {1,3,2};
        nextPermutation(nums);
        for(int x:nums){
            System.out.print(x +" ");
        }

    }
    public static void nextPermutation(int[] nums) {
        int index;
        int i;
        for(index = nums.length - 1;index > 0;index--){
            if(nums[index] <= nums[index - 1])
                continue;
            else
                break;
        }
        int low = index;
        int high = nums.length - 1;
        if(low == 0){
            while(low < high){
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
        else{
            int j = low - 1;
            for(i = nums.length - 1;i > 0;i--){
                if(nums[i] > nums[j]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
            high = nums.length - 1;
            while(low < high){
                int temp = nums[low];
                nums[low] = nums[high];
                nums[high] = temp;
                low++;
                high--;
            }
        }
    }

}
