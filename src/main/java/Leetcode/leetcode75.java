package Leetcode;

public class leetcode75 {
    public static void main(String[] args) {
        int[] a = {1,1,0,1,2,1,2,0,1,2,1,2};
        sortColors(a);
        for(int x : a)
            System.out.print(x+" ");
    }
    public static void sortColors(int[] nums) {
        int high = nums.length - 1;
        int low = 0;
        while(low < high){
            while(nums[high] == 2)
                high--;
            while(nums[low] != 2)
                low++;
            if(low >= high)
                break;
            int temp = nums[high];
            nums[high] = nums[low];
            nums[low] = temp;
            low++;
            high--;
        }
        for(int i = nums.length - 1;i >= 0;i--){
            if(nums[i] != 2){
                high = i;
                break;
            }
        }
        low = 0;
        while(low < high){
            while(nums[high] == 1)
                high--;
            while(nums[low] != 1)
                low++;
            if(low >= high)
                break;
            int temp = nums[high];
            nums[high] = nums[low];
            nums[low] = temp;
            low++;
            high--;
        }
    }
}
