package Leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class leetcode1030 {

    public static int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int[][] res = new int[rows * cols][2];
        Map<Integer, List<Integer>> row = new HashMap<>();
        Map<Integer,List<Integer>> col = new HashMap<>();
        int a = rows - rCenter > rCenter ? rows : 0;
        int b = cols - cCenter > cCenter ? cols : 0;
        int x = 0;
        int max = Math.abs(a - rCenter) + Math.abs(b - cCenter);
        for(int i = 0;i <= max;i++){
            row.put(i,new ArrayList<Integer>());
            col.put(i,new ArrayList<Integer>());
        }
        for(int i = 0;i < rows;i++){
            for(int j = 0;j < cols;j++){
                int temp = Math.abs(i - rCenter) + Math.abs(j - cCenter);
                row.get(temp).add(i);
                col.get(temp).add(j);
            }
        }
        for(int i = 0;i <= max;i++){
            List<Integer> list1 = row.get(i);
            List<Integer> list2 = col.get(i);
            for(int count = 0;count < list1.size();count++){
                res[x][0] = list1.get(count);
                res[x][1] = list2.get(count);
                x++;
            }
        }
        return res;
    }
}
