package WithWeight_DirectedGraph;

import WithWeight_UndirectedGraph.Edge;

import java.util.ArrayList;
import java.util.List;

public class EdgeWeightedDigraph {
    private final int V;  //顶点数目
    private int E;  //边的数目
    private List<DirectedEdge>[] adj;   //邻接表

    public EdgeWeightedDigraph(int V) {
        this.V = V;
        this.E = 0;
        this.adj = new ArrayList[V];
        for (int i = 0; i < V; i++) {
            adj[i] = new ArrayList<DirectedEdge>();
        }
    }
    public void addEdge(DirectedEdge e) {  //有向边，每条边仅存储一次
        adj[e.from()].add(e);
        E++;
    }

    public int V() {
        return V;
    }
    public int E() {
        return E;
    }

    public Iterable<DirectedEdge> adj(int v) {    //获取某个顶点的邻接链表
        return adj[v];
    }
    public Iterable<DirectedEdge> edges() {
        List<DirectedEdge> edges = new ArrayList<>();
        for (int v = 0; v < V; v++) {
            edges.addAll(adj[v]);
        }
        return edges;
    }
}
