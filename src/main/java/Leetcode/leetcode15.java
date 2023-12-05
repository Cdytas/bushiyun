package Leetcode;

import xiaozibei.BUBBLE;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode15 {
    public static void main(String[] args) {
        int []nums = {-2,-1,0,1,2,3};
        List<List<Integer>> l3 = threeSum(nums);
        System.out.print(l3.toString());
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        int length1 = nums.length - 2;
        int length2 = nums.length - 1;
        int length3 = nums.length;
        Arrays.sort(nums);
        for(int i = 0;i < length1;i++){
            if(nums[i] > 0)
                return list;
            if(i != 0 && nums[i] == nums[i - 1])
                continue;
            for(int j =  i + 1;j < length2;j++){
                if(nums[i] + nums[j] > 0)
                    return list;
                if(j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                for(int k = j + 1;k < length3;k++){
                    if(nums[i] + nums[j] + nums[k] > 0){
                        continue;   
                    }
                    if(k > j + 1 && nums[k] == nums[k - 1])
                        continue;
                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> list1 = new ArrayList<>();
                        list1.add(nums[i]);
                        list1.add(nums[j]);
                        list1.add(nums[k]);
                        list.add(list1);
                    }
                }
            }
        }
        return list;
    }
}
