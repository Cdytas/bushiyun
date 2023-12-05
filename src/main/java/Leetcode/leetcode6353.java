package Leetcode;

public class leetcode6353 {
    Integer[][] dp;

    public static void main(String[] args) {
        leetcode6353 ins = new leetcode6353();
        int[][] grid = {{2,1,0},{1,0,0}};
        int res = ins.minimumVisitedCells(grid);
        System.out.println(res);

    }
    public  int minimumVisitedCells(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        dp = new Integer[m][n];
        dfs(m - 1, n - 1, grid);
        return dp[m - 1][n - 1];

    }

    public int dfs(int i,int j, int[][] grid) {
        if (i == 0 && j == 0) {
            return 1;
        }
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        int minOfRow = Integer.MAX_VALUE;
        int minOfCol = Integer.MAX_VALUE;
        for (int row = i - 1; row >= 0; row--) {
            if (grid[row][j] >= i - row) {
                int len = dfs(row, j, grid);
                if (len == -1) {
                    continue;
                }
                else {
                    minOfRow = Math.min(minOfRow, len + 1);
                }
            }
        }
        for (int col = j - 1; col >= 0; col--) {
            if (grid[i][col] >= j - col) {
                int len = dfs(i, col, grid);
                if (len == -1) {
                    continue;
                }
                else {
                    minOfCol = Math.min(minOfCol, len + 1);
                }
            }
        }
        if (minOfRow == Integer.MAX_VALUE && minOfCol == Integer.MAX_VALUE) {
            dp[i][j] = -1;
            return dp[i][j];
        }
        dp[i][j] = Math.min(minOfRow, minOfCol);
        return dp[i][j];

    }
}
