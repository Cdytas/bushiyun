package Leetcode;

public class leetcode1605 {
    public static void main(String[] args){
        int[] rowSum = {3,8};
        int[] colSum = {4,7};
        int[][] res = restoreMatrix(rowSum,colSum);
        for(int i = 0;i < res.length;i++){
            for(int j = 0;j < res[0].length;j++){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }



    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int row = rowSum.length;
        int col = colSum.length;
        int[][] res = new int[row][col];
        for(int i = 0;i < row;i++){
            res[i][0] = rowSum[i];
        }
        for(int j = 1;j < col;j++){
            for(int i = 0;i < row;i++){
                if(res[i][0] >= colSum[j]){
                    res[i][j] = colSum[j];
                    res[i][0] -= colSum[j];
                    colSum[j] = 0;
                    break;
                }
                else{
                    res[i][j] = res[i][0];
                    colSum[j] -= res[i][0];
                    res[i][0] = 0;
                }
            }
        }
        return res;
    }
}
