package Leetcode;
import java.util.*;
public class leetcode1377 {

    Map<Integer, Double> memo = new HashMap<>();
    List[] adj;  //邻接表
    int t;
    int target;
    boolean[] used;

    public static void main(String[] args) {
        int[][] edges = {{1,2},{1,3},{1,7},{2,4},{2,6},{3,5}};
        leetcode1377 execc = new leetcode1377();
        double res = execc.frogPosition(7,edges,2,4);
        System.out.println(res);
    }
    public double frogPosition(int n, int[][] edges, int t, int target) {
        this.adj = new ArrayList[n + 1];
        this.t = t;
        this.used = new boolean[n + 1];
        int e = edges.length;
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < e; i++) {
            adj[edges[i][0]].add(edges[i][1]);
            adj[edges[i][1]].add(edges[i][0]);
        }
        used[1] = true;
        dfs(1, 0, 1.0);
        return memo.containsKey(target) ? memo.get(target) : 0;
    }

    public void dfs(int node, int time, double now) {
        if (time == t) {  //时间耗尽
            memo.put(node, now);
            return;
        }
        List<Integer> list = adj[node];
        int count = list.size() - 1;  //从node结点能到的结点少了一个，因为不能回到父节点
        if (count == 0) {  //时间未用完前到达某个叶子结点
            memo.put(node, now);
            return;
        }
        double prob = now / count; //到孩子结点的概率
        for (int x : list) {
            if (!used[x]) {
                used[x] = true;
                dfs(x, time + 1, prob);
            }
        }
    }
}
