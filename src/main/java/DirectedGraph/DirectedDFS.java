package DirectedGraph;


public class DirectedDFS {
    private boolean[] marked;  //用于标记某个顶点是否访问过
    public DirectedDFS(Digraph G, int start) {  //判断从顶点start能到达哪些其他顶点
        this.marked = new boolean[G.V()];
        dfs(G, start);
    }

    public DirectedDFS(Digraph G, Iterable<Integer> sources) {   //判断一组顶点能到达哪些其他顶点
        this.marked = new boolean[G.V()];
        for (int start : sources) {
            if (!marked[start]) {
                dfs(G, start);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        marked[v] = true;   // 顶点v已访问
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
    }
    public boolean marked(int w) {   //若返回值为true，表示与顶点w连通
        return marked[w];
    }

}
