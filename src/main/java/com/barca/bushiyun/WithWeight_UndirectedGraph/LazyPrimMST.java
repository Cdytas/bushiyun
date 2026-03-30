package com.barca.bushiyun.WithWeight_UndirectedGraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class LazyPrimMST {
    private boolean[] marked;  //某个顶点是否已并入生成树中？
    private Deque<Edge> mst; //已并入树中的边的集合，以队列存储
    private PriorityQueue<Edge> pq;// 优先队列，小根堆。用于选取当前权值最小的横切边
    private double weight;

    public LazyPrimMST(EdgeWeightedGraph G) {
        pq = new PriorityQueue<Edge>();
        mst = new ArrayDeque<Edge>();
        marked = new boolean[G.V()];
        weight = 0;
        visit(G, 0);  //从0号结点开始构造生成树
        while (!pq.isEmpty()) {
            Edge e = pq.remove();
            int v = e.either();
            int w = e.other(v);
            if (marked[v] && marked[w]) {  //这条边连接的两个结点都已并入树中，这条边失效
                continue;
            }
            mst.offerLast(e);
            weight += e.weight();   //边e的权值加入树的总权值中
            if (!marked[v]) {
                visit(G, v);  //v结点并入树中
            }
            if (!marked[w]) {
                visit(G, w); //w结点并入树中
            }
        }
    }

    private void visit(EdgeWeightedGraph G, int v) {
        marked[v] = true;
        for (Edge e : G.adj(v)) {
            if (!marked[e.other(v)]) {  //边e的另一个结点还未并入树中，边e是横切边，加入优先队列
                pq.add(e);
            }
        }
    }
    public Iterable<Edge> edges() {  //返回最小生成树的边的集合
        return mst;
    }
    public double weight() {  //返回树的动态总权值
        return weight;
    }
}
