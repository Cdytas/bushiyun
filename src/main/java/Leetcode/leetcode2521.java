package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode2521 {
    public static void main(String[] args) {
        int[] a = {3};
        System.out.print(distinctPrimeFactors(a));
    }


    public static int distinctPrimeFactors(int[] nums) {
        int count = 0;
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums);
        if(nums[nums.length - 1] < 2)
            return 0;
        else if(nums[nums.length - 1] == 2)
            return 1;
        for(int i = 2;i <= nums[nums.length - 1];i++){
            if(zhishu(i))
                list.add(i);
        }
        List<Integer> list2 = new ArrayList<Integer>();
        for(int i = 0;i < nums.length;i++){
            for(int j = 0;j < list.size();j++){
                if(nums[i] % list.get(j) == 0 && !list2.contains(list.get(j)))
                    list2.add(list.get(j));
            }
        }
        return list2.size();
    }

    public static boolean zhishu(int n){
        if(n == 1)
            return false;
        for(int i = 2;i <= Math.sqrt(n);i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
