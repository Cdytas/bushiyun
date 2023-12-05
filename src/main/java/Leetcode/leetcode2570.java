package Leetcode;

import java.util.Arrays;

public class leetcode2570 {
    public static void main(String[] args) {
        int[][] nums1 = {{1,2},{2,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2},{4,1}};
        int[][] res = mergeArrays(nums1,nums2);

    }


    public static int[][] mergeArrays(int[][] nums1, int[][] nums2){
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[][] res = new int[len1 + len2][2];
        int index1 = 0;
        int index2 = 0;
        int index = 0;
        while(index1 < len1 && index2 < len2){
            if(nums1[index1][0] == nums2[index2][0]){
                res[index][0] = nums1[index1][0];
                res[index][1] = nums1[index1][1] + nums2[index2][1];
                index1++;
                index2++;
                index++;
            }
            else if(nums1[index1][0] < nums2[index2][0]){
                res[index][0] = nums1[index1][0];
                res[index][1] = nums1[index1][1];
                index1++;
                index++;
            }
            else{
                res[index][0] = nums2[index2][0];
                res[index][1] = nums2[index2][1];
                index2++;
                index++;
            }
            if(index1 == len1 && index2 == len2) break;
            if(index1 == len1){
                while(index2 != len2){
                    res[index][0] = nums2[index2][0];
                    res[index][1] = nums2[index2][1];
                    index2++;
                    index++;
                }
                break;
            }
            if(index2 == len2){
                while(index1 != len1){
                    res[index][0] = nums1[index1][0];
                    res[index][1] = nums1[index1][1];
                    index1++;
                    index++;
                }
                break;
            }
        }
        res = Arrays.copyOf(res,index);
        return res;
    }
}
