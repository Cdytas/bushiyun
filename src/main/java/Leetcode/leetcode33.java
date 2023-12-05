package Leetcode;

public class leetcode33 {
    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(SearchForIndex(nums));
        /*System.out.print(search(nums,0));*/
    }


    public static int SearchForIndex(int[] nums) {
        int index;
        if (nums[0] < nums[nums.length - 1])
            index = 0;
        else{
            int low = 0;
            int high = nums.length - 1;
            int mid = 0;
            while (low <= high) {
                mid = low + (high - low) / 2;
                if (nums[mid] > nums[0])
                    low = mid + 1;
                else if (nums[mid] < nums[0])
                    high = mid - 1;
            }
            index = mid;
            if(nums[index] < nums[index - 1])
                index = index - 1;
        }
        return index;
    }

    public static int search(int[] nums,int target){
        int index = SearchForIndex(nums);
        int index1 = index + 1;
        int low = 0;
        int high = nums.length - 1;
        if(target >= nums[0]){
            while(low <= index){
                int mid1 = low + (index - low) / 2;
                if(nums[mid1] == target)
                    return mid1;
                else if(nums[mid1] < target)
                    low = mid1 + 1;
                else
                    index = mid1 - 1;
            }
        }
        else{
            while(index1 <= high){
                int mid2 = index1 + (high - index1) / 2;
                if(nums[mid2] == target)
                    return mid2;
                else if(nums[mid2] < target)
                    index1 = mid2 + 1;
                else
                    high = mid2 - 1;
            }
        }
        return -1;
    }
}

