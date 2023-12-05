package Leetcode;

public class leetcode73 {
    public static void main(String[] args) {
        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(matrix);
    }

    public static void setZeroes(int[][] matrix) {
        int[] a = new int[matrix.length];
        int[] b = new int[matrix[0].length];
        for(int i = 0;i < matrix.length;i++){
            for(int j = 0;j < matrix[0].length;j++){
                if(matrix[i][j] == 0) {
                    a[i] = 1;
                    b[j] = 1;
                }
            }
        }
        for(int i = 0;i < a.length;i++){
            if(a[i] == 1){
                for(int k = 0;k < matrix[0].length;k++){
                    matrix[i][k] = 0;
                }
            }
        }
        for(int i = 0;i < b.length;i++){
            if(b[i] == 1){
                for(int k = 0;k < matrix.length;k++){
                    matrix[k][i] = 0;
                }
            }
        }
    }
}
