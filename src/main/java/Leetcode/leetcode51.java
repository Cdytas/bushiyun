package Leetcode;
import  java.util.*;
public class leetcode51 {

    List<List<String>> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    boolean[] usedOfleft;
    boolean[] usedOfRight;
    boolean[] usedOfCol;

    public static void main(String[] args) {
        leetcode51 exc = new leetcode51();
        exc.res = exc.solveNQueens(4);
        for (List<String> list : exc.res) {
            System.out.println(list.toString());
        }
    }
    public List<List<String>> solveNQueens(int n) {
        int len = 2 * n - 1;
        this.usedOfleft = new boolean[len];
        this.usedOfRight = new boolean[len];
        this.usedOfCol = new boolean[n];
        dfs(0, n);
        return res;
    }

    public void dfs(int row, int n) {
        if (row == n) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (usedOfRight[row + n - 1 - j] || usedOfleft[row + j] || usedOfCol[j]) {
                continue;
            }
            char[] str = new char[n];
            Arrays.fill(str, '.');
            str[j] = 'Q';
            usedOfRight[row + n - 1 - j] = true;
            usedOfleft[row + j] = true;
            usedOfCol[j] = true;
            path.add(String.valueOf(str));
            dfs(row + 1, n);
            usedOfRight[row + n - 1 - j] = false;
            usedOfleft[row + j] = false;
            usedOfCol[j] = false;
            path.remove(path.size() - 1);
        }
    }
}
