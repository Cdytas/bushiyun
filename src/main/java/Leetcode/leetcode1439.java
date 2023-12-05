package Leetcode;

public class leetcode1439 {
    public static void main(String[] args) {
        int[][] mat = {{1,3,11},{2,4,6}};
        System.out.println(kthSmallest(mat, 5));

    }

    public static int kthSmallest(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] improve = new int[m][n - 1];
        int[] index = new int[m]; //每一行取的是哪个下标来组成数组? 初始全为0
        int res = 0;
        int add, row, col;
        for (int i = 0; i < m; i++) {
            res += mat[i][0];
            for (int j = 0; j < n - 1; j++) {
                improve[i][j] = mat[i][j + 1] - mat[i][j];  //当前行数据后移一位能获得的提升
            }
        }
        for (int cnt = 1; cnt < k; cnt++) {
            add = Integer.MAX_VALUE;  //移动可获得的提升
            row = -1; //要移动的行
            for (int i = 0; i < m; i++) {
                col = index[i];
                if (col != n - 1 && improve[i][col] < add) {
                    add = improve[i][col];
                    row = i;
                }
            }
            res += add;
            index[row]++;  //row行右移一位，组成新的数组
        }
        return res;
    }
}
