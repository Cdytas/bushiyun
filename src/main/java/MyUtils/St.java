package MyUtils;

public class St {
    int n;
    int r;
    int[] arr;
    int[][] max;
    int[][] min;
    int[] s;

    public static void main(String[] args) {
        int[] arr = {1, 7, 3, 4, 2, 5};
        St st = new St(arr);
        int[][] queries = {{0, 4}, {3, 5}, {1, 1}};
        for (int[] q : queries) {
            int left = q[0];
            int right = q[1];
            System.out.println(st.findMax(left, right) - st.findMin(left, right));
        }
    }

    public St(int[] arr) {
        int len = arr.length;
        this.n = len;
        this.arr = arr;

        while (len > 1) {
            len /= 2;
            r++;
        }

        this.max = new int[n][r + 1];
        this.min = new int[n][r + 1];
        this.s = new int[r + 1];

        for (int  i = 0; i < n; i++) {
            max[i][0] = arr[i];
            min[i][0] = arr[i];
        }
        s[0] = 1;
        for (int i = 1; i <= r; i++) {
            s[i] = s[i - 1] * 2;
        }
        this.init();
    }

    private  void init() {
        for (int j = 1; j <= r; j++) {
            for (int i = 0; i + s[j] - 1< n; i++) {  // 范围从i到i + s[j] - 1, 共2^j个数
                max[i][j] = Math.max(max[i][j - 1], max[i + s[j - 1]][j - 1]);
                min[i][j] = Math.min(min[i][j - 1], min[i + s[j - 1]][j - 1]);
            }
        }
    }

    public int findMax(int left, int right) {
        int len = right - left + 1;
        int r = 0;
        while (len > 1) {
            len /= 2;
            r++;
        }
        return Math.max(max[left][r], max[right - s[r] +1][r]);
    }

    public int findMin(int left, int right) {
        int len = right - left + 1;
        int r = 0;
        while (len > 1) {
            len /= 2;
            r++;
        }
        return Math.min(min[left][r], min[right - s[r] +1][r]);
    }
}
