package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class leetcode54 {
    public static void main(String[] args) {
        int[][] matrix = {{7}, {9}, {6}};
        List<Integer> list = spiralOrder(matrix);
        System.out.print(list);
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        int row1 = 0,row2 = matrix.length - 1;
        int column1 = 0,column2 = matrix[0].length - 1;
        int i,j;
        while(row1 <= row2 && column1 <= column2){
            for(j = column1;j <= column2;j++){
                i = row1;
                list.add(matrix[i][j]);
            }
            if(row1 == row2)
                break;
            for(i = row1 + 1;i <= row2;i++){
                j = column2;
                list.add(matrix[i][j]);
            }
            if(column1 == column2)
                break;
            for(j = column2 - 1;j >= column1;j--){
                i = row2;
                list.add(matrix[i][j]);
            }
            for(i = row2 - 1;i > row1;i--){
                j = column1;
                list.add(matrix[i][j]);
            }
            row1++;
            row2--;
            column1++;
            column2--;
        }
        return list;
    }
}
