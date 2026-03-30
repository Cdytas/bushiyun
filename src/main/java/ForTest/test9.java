package ForTest;


public class test9 {
    public static void main(String[] args) throws InterruptedException {
        test9 test9 = new test9();
        int[][] grid = {{3,4,5,1,3},{3,3,4,2,3},{20,30,200,40,10},{1,5,5,4,1},{4,3,2,2,5}};
        System.out.println(test9.getBiggestThree(grid));

    }

    int m;
    int n;
    public int[] getBiggestThree(int[][] grid) {
        this.m = grid.length;
        this.n = grid[0].length;
        int[] res = new int[3];
        int[][] left = new int[m + n][m + 1];
        int[][] right = new int[m + n][m + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int k = Math.min(i, j);
                int xL = i - k;
                int yL = j - k;
                int start = xL > 0 ? n + xL : yL;
                int cnt = k + 1;
                left[start][cnt] = left[start][cnt - 1] + grid[i][j];

                k = Math.min(i, n - 1 - j);
                int xR = i - k;
                int yR = j + k;
                start = xR + yR;
                cnt = k + 1;
                right[start][cnt] = right[start][cnt - 1] + grid[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                update(res, grid[i][j]);
                for (int k = i + 2; k < m; k+= 2) {
                    int h = k - i;
                    int w = h / 2;
                    if (j - w < 0 || j + w >= n) {
                        break;
                    }

                    int a = queryL(left, i, j, w + 1);
                    int b = queryR(right, i + w + 1, j - w + 1, w);
                    int c = queryL(left, i + 1, j + 1, w);
                    int d = queryR(right, i + w + 1, j + w - 1, w - 1);
                    update(res, a + b + c + d);
                }
            }
        }

        if (res[1] == 0) {
            res = new int[]{res[0]};
        } else if (res[2] == 0) {
            res = new int[]{res[0], res[1]};
        }

        return res;
    }

    public int queryL(int[][] left, int i, int j, int c) {
        int k = Math.min(i, j);
        int xL = i - k;
        int yL = j - k;
        int start = xL > 0 ? n + xL : yL;
        int cnt = k + 1;

        return left[start][cnt + c - 1] - left[start][cnt - 1];
    }

    public int queryR(int[][] right, int i, int j, int c) {
        int k = Math.min(i, n - 1 - j);
        int xR = i - k;
        int yR = j + k;
        int start = xR + yR;
        int cnt = Math.min(xR + 1, n - yR);
        return right[start][cnt + c - 1] - right[start][cnt - 1];
    }

    public void update(int[] res, int target) {
        if (target < res[2] || target == res[0] || target == res[1] || target == res[2]) {
            return;
        }

        if (target > res[0]) {
            res[2] = res[1];
            res[1] = res[0];
            res[0] = target;
        } else if (target > res[1]) {
            res[2] = res[1];
            res[1] = target;
        } else if (target > res[2]) {
            res[2] = target;
        }
    }


}
