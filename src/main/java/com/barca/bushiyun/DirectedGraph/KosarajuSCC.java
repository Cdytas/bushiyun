package com.barca.bushiyun.DirectedGraph;

public class KosarajuSCC {
    private boolean[] marked;
    private int[] id;  //连通分量标识符数组
    private int count;  //连通分量数

    public KosarajuSCC(Digraph G) {
        marked = new boolean[G.V()];
        id = new int[G.V()];
        count = 0;
        DepthFirstOrder order = new DepthFirstOrder(G.reverse());  //利用G的反向图得到结点的逆后序排序，即拓扑排序
        for (int s : order.reversePost()) {   //遍历G的拓扑排序结果，可能会产生新的强连通分量
            if (!marked[s]) {
                dfs(G, s);
                count++;
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;
        id[v] = count;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }

    public boolean stronglyConnected(int v, int w) {
        return id[v] == id[w];
    }

    public int id(int v) {
        return id[v];
    }

    public int count() {
        return count;
    }

}
