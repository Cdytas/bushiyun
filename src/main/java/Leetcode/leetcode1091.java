package Leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class leetcode1091 {
    public static void main(String[] args) {
        int[][] grid = {{0,1},{1,0}};
        System.out.println(shortestPathBinaryMatrix(grid));

    }

    public static int shortestPathBinaryMatrix(int[][] grid) {
        if (grid[0][0] == 1) {
            return -1;
        }
        int n = grid.length;
        if (n == 1 && grid[0][0] == 0) {
            return 1;
        }
        boolean[][] marked = new boolean[n][n];  //记录某个点是否访问过
        Deque<Integer> deque = new ArrayDeque<>();  //用来做BFS
        int res = 1;   //最短路径长度
        deque.offerLast(0);
        deque.offerLast(0);  //起点入队
        marked[0][0] = true;
        while (!deque.isEmpty()) {
            int count = deque.size() / 2;  //本层结点数
            res++;  //路径长度加1
            for (int cnt = 0; cnt < count; cnt++) {
                int x = deque.pollFirst();
                int y = deque.pollFirst();
                for (int i = Math.max(x - 1, 0); i <= Math.min(x + 1, n - 1); i++) {
                    for (int j = Math.max(y - 1, 0); j <= Math.min(y + 1, n - 1); j++) {
                        if (marked[i][j] || grid[i][j] == 1) {
                            continue;
                        }
                        if (i == n - 1 && j == n - 1) {
                            return res;
                        }
                        marked[i][j] = true;
                        deque.offerLast(i);
                        deque.offerLast(j);
                    }
                }
            }
        }
        return -1;  //没有路径能到终点
    }
}
