package Leetcode;
import java.util.ArrayList;
import java.util.List;
public class leetcode315 {
    public static void main(String[] args) {
       int []nums = {2,0,1};
       System.out.print(countSmaller(nums).toString());
    }
    public static List<Integer> countSmaller(int[] nums){
        List<Integer> list = new ArrayList<>();
        List<Integer> reverse = new ArrayList<>();
        list.add(0);
        for(int i = nums.length - 2;i >= 0;i--){
            int j = i + 1;
            int k = nums.length - j - 1;
            while(j < nums.length){
                if(nums[i] > nums[j]){
                    list.add(list.get(k) + 1);
                    break;
                }
                else if(nums[i] == nums[j]){
                    list.add(list.get(k));
                    break;
                }
                else{
                    j++;
                    k--;
                }
                if(j == nums.length)
                    list.add(0);
            }
        }
        for(int i = nums.length - 1;i >= 0;i--)
            reverse.add(list.get(i));
        return reverse;
    }
}
