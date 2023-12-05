package WithWeight_UndirectedGraph;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedGraph {
    private final int V;  //顶点数目
    private int E;  //边的数目
    private List<Edge>[] adj;   //邻接表

    public EdgeWeightedGraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<Edge>();
        }
    }
    public void addEdge(Edge e) {  //每条边存储两次
        int v = e.either();
        int w = e.other(v);
        adj[v].add(e);
        adj[w].add(e);
        E++;
    }

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }

    public Iterable<Edge> adj(int v) {    //获取某个顶点的邻接链表
        return adj[v];
    }
    public Iterable<Edge> edges() {
        List<Edge> b = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            for (Edge e : adj[v]) {
                if (e.other(v) > v) {  //保证每条边只加入一次
                    b.add(e);
                }
            }
        }
        return b;
    }
}
