package ForTest;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] nums = {5,4,8,6};
        int[][] queries = {{1,2,2},{1,1,2},{2,1,6}};
        List<Integer> res = new Main().countOfPeaks(nums, queries);
    }
    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        TreeArray ta = new TreeArray(n);
        boolean[] isF = new boolean[n];
        for (int i = 1; i < n - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                isF[i] = true;
                ta.add(i + 1, 1);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int[] q : queries) {
            int type = q[0];
            if (type == 2) {
                int i = q[1];
                int val = q[2];
                nums[i] = val;  //变值
                if (i == 0) {
                    if (isF[1] && nums[0] >= nums[1]) {  //破坏峰值
                        isF[1] = false;
                        ta.add(2, -1);
                    }
                    if (!isF[1] && nums[0] < nums[1] && nums[2] < nums[1]) {
                        isF[1] = true;
                        ta.add(2, 1);
                    }
                }
                else if (i == n - 1) {
                    if (isF[n - 2] && nums[n - 1] >= nums[n - 2]) {  //破坏峰值
                        isF[n - 2] = false;
                        ta.add(n - 1, -1);
                    }
                    if (!isF[n - 2] && nums[n - 1] < nums[n - 2] && nums[n - 3] < nums[n - 2]) {
                        isF[n - 2] = true;
                        ta.add(n - 1, 1);
                    }
                }
                else {
                    if (isF[i - 1] && nums[i - 1] <= nums[i]) {
                        isF[i - 1] = false;
                        ta.add(i, -1);
                    }
                    else if (!isF[i - 1] && i - 2 >= 0 && nums[i - 1] > nums[i - 2] && nums[i - 1] > nums[i]) {
                        isF[i - 1] = true;
                        ta.add(i, 1);
                    }
                    if (isF[i + 1] && nums[i + 1] <= nums[i]) {
                        isF[i + 1] = false;
                        ta.add(i + 2, -1);
                    }
                    else if (!isF[i + 1] && i + 2 < n && nums[i + 1] > nums[i + 2] && nums[i + 1] > nums[i]) {
                        isF[i + 1] = true;
                        ta.add(i + 2, 1);
                    }
                    if (isF[i] && (nums[i] <= nums[i - 1] || nums[i] <= nums[i + 1])) {
                        isF[i] = false;
                        ta.add(i + 1, -1);
                    }
                    else if (!isF[i] && nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                        isF[i] = true;
                        ta.add(i + 1, 1);
                    }
                }
            }
            else {
                int l = q[1];
                int r = q[2];
                int cnt = ta.query(r + 1) - ta.query(l);
                if (isF[l]) {
                    cnt--;
                }
                if (isF[r]) {
                    cnt--;
                }
                res.add(cnt);
            }
        }
        return res;
    }
}

class TreeArray {
    private int[] tree;
    private int[] A;
    private int n;

    public TreeArray(int n) {
        this.n = n;
        this.A =  new int[n + 1];
        this.tree = new int[n + 1];  //构建管控数组，下标从 1 ~ n
    }

    public int lowbit(int m) {
        return m & -m;
    }

    public int query(int x) {  //查询前x个元素的和
        int res = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            res += tree[i];
        }
        return res;
    }

    public void add(int i, int u) {  //nums[i]若增加u，tree数组中所有管控nums[i]的值也要相应增加
        for (int j = i; j <= n; j += lowbit(j)) {
            tree[j] += u;
        }
    }
}








