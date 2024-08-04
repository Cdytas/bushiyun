package LuoGu;

import java.util.Scanner;

public class P1006 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int m = input.nextInt();
        int n = input.nextInt();
        int[][] arr = new int[m][n];
        int[][] dirs = {{-1, 0}, {0, -1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = input.nextInt();
            }
        }

        int[][][][] dp = new int[m][n][m][n];
        dp[0][0][0][0] = arr[0][0];
        for (int k = 1; k < m + n - 1; k++) {  // 枚举i + j的和
            for (int r1 = k < m ? 0 : k - m + 1; r1 <= Math.min(k, m - 1); r1++) {
                int c1 = k - r1;
                if (r1 == m - 1 && c1 == n - 1) {
                    update(dp, r1, c1, r1, c1, arr, dirs);
                    break;
                }
                for (int r2 = r1 + 1; r2 <= Math.min(k, m - 1); r2++) {
                    int c2 = k - r2;
                    update(dp, r1, c1, r2, c2, arr, dirs);
                }
            }
        }
        System.out.print(dp[m - 1][n - 1][m - 1][n - 1]);
    }

    private static void update(int[][][][] dp, int r1, int c1, int r2, int c2, int[][] arr, int[][] dirs) {
        int m = arr.length;
        int n = arr[0].length;
        for (int[] d1 : dirs) {
            int x1 = r1 + d1[0];
            int y1 = c1 + d1[1];
            if (x1 < 0 || y1 < 0) {
                continue;
            }
            for (int[] d2 : dirs) {
                int x2 = r2 + d2[0];
                int y2 = c2 + d2[1];
                if (x2 < 0 || y2 < 0) {
                    continue;
                }
                if (x1 != x2 || (x1 == 0 && y1 == 0)) {
                    if (r1 == m - 1 && c1 == n - 1) {
                        dp[r1][c1][r2][c2] = Math.max(dp[r1][c1][r2][c2], dp[x1][y1][x2][y2] + arr[r1][c1]);
                    } else {
                        dp[r1][c1][r2][c2] = Math.max(dp[r1][c1][r2][c2], dp[x1][y1][x2][y2] + arr[r1][c1] + arr[r2][c2]);
                    }
                }
            }
        }
    }
}
