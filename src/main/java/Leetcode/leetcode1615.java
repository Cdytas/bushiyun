package Leetcode;

import java.util.*;

public class leetcode1615  {
    public static void main(String[] args) {
       int[][] roads = {{0,1},{0,3},{1,2},{1,3}};
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
       System.out.println(maximalNetworkRank(4, roads));
    }
    public static int maximalNetworkRank(int n, int[][] roads) {
        int[][] exist = new int[n][n];
        int[] sum = new int[n];
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < roads.length; i++) {
            int c1 = roads[i][0];
            int c2 = roads[i][1];
            sum[c1]++;
            sum[c2]++;
            exist[c1][c2] = 1;
            exist[c2][c1] = 1;
        }
        int max1 = 0;
        int max2 = 0;
        for (int i = 0; i < n; i++) {
            if (sum[i] > max1) {
                max2 = max1;
                list2 = list1;
                max1 = sum[i];
                list1 = new ArrayList<>();
                list1.add(i);
                continue;
            }
            else if (sum[i] == max1) {
                list1.add(i);
                continue;
            }
            else if (sum[i] > max2) {
                max2 = sum[i];
                list2 = new ArrayList<>();
                list2.add(i);
            }
            else if (sum[i] == max2) {
                list2.add(i);
            }
        }
        if (list1.size() > 1) {
            for(int i = 0; i < list1.size() - 1; i++) {
                int c1 = list1.get(i);
                for(int j = i + 1; j < list1.size(); j++) {
                    int c2 = list1.get(j);
                    if (exist[c1][c2] == 0 && exist[c2][c1] == 0) {
                        return max1 * 2;
                    }
                }
            }
            return max1 * 2 - 1;
        }
        else {
            int c1 = list1.get(0);
            for (int i = 0; i < list2.size(); i++) {
                int c2 = list2.get(i);
                if (exist[c1][c2] == 0 && exist[c2][c1] == 0) {
                    return max1 + max2;
                }
            }
            return max1 + max2 - 1;
        }
    }
}
