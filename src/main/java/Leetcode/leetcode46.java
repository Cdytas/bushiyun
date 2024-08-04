package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode46 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length == 0)
            return res;
        List<Integer> path = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        dfs(res,nums,0,used,path);
        return res;
    }

    public static void dfs(List<List<Integer>> res,int[] nums,int depth,boolean[] used,List<Integer> path){
        if(depth == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = 0;i < nums.length;i++){
            if(!used[i]){
                path.add(nums[i]);
                used[i] = true;
                dfs(res,nums,depth + 1,used,path);
                path.remove(path.size() - 1);  //回溯，状态重置
                used[i] = false;
            }
        }
    }
}
