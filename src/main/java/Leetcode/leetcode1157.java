package Leetcode;
import java.util.*;
public class leetcode1157 {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 1, 1};
        Majority(arr);
    }

    public static void Majority(int[] arr) {
        int[] memo = new int[20001]; //用于记录哪些数出现过
        int n = arr.length;
        int typeofnum = 0;
        Map<Integer,Integer> map1 = new HashMap<>();
        Map<Integer,Integer> map2 = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (memo[arr[i]] != 0) {
                continue;  //arr[i]出现过
            }
            else {
                map1.put(typeofnum, arr[i]);
                map2.put(arr[i], typeofnum);     //将出现的数存入hash表方便存取
                typeofnum++;
                memo[arr[i]] = 1; //将arr[i]标记为已出现
            }
        }

        int[][][] pre = new int[n + 1][typeofnum][1];

        for (int i = 1; i <= n; i++) {
            int type = map2.get(arr[i - 1]);
            for (int j = 0; j < type; j++) {
                pre[i][j][0] = pre[i - 1][j][0];
            }
            pre[i][type][0] = pre[i - 1][type][0] + 1;
            for (int j = type + 1; j < typeofnum; j++) {
                pre[i][j][0] = pre[i - 1][j][0];
            }
        }
    }
}
