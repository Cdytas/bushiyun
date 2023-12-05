/*package Leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class leetcode39 {
    public static void main(String[] args) {

        }
    public static List<List<Integer>> combinationSum(int []candidates,int target){
        List<List> list1 = new ArrayList<>();
        for(int i = candidates.length - 1;i > 0;i--){
            for(int j = 0;j <= i - 1;j++){
                if(candidates[j] > candidates[j +1]){
                    int temp = candidates[j];
                    candidates[j] = candidates[j + 1];
                    candidates[j + 1] = temp;
                }
            }
        }
        int index = 0;
        boolean flag = false;
        for(int i = 0;i < candidates.length - 1;i++){
            if(candidates[i] <= target && candidates[i + 1] > target){
                index = i + 1;
                flag = true;
                break;
            }
        }
        if(flag == false){
            index = candidates.length - 1;
        }
        for(int i = 0;i < index; i++){
            if (candidates[i] % target == 0){
                int medium = candidates[i];
                int count = 0;
                while(medium != 0){
                    medium = medium - target;
                    count++;
                }
                List<Integer> list2 = new ArrayList<>();
                for(int j = 0;i < count;i++){
                    list2.add(candidates[i]);
                }
                list1.add(list2);
            }
        }

    }




}*/

