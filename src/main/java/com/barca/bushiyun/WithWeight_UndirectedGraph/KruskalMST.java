package com.barca.bushiyun.WithWeight_UndirectedGraph;

import com.barca.bushiyun.UndirectedGraph.UnionFind;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;

public class KruskalMST {
    private Deque<Edge> mst;  //已并入树中的边的集合，以队列存储
    private double weight; //最小生成树的总权值

    public KruskalMST(EdgeWeightedGraph G) {
        mst = new ArrayDeque<Edge>();
        PriorityQueue<Edge> pq = new PriorityQueue<>();  //存储所有边并逐个取出权值最小者
        for (Edge e : G.edges()) {
            pq.add(e);
        }
        UnionFind uf = new UnionFind(G.V());  //构建并查集，用于存储任意两个结点的连接状态

        while (!pq.isEmpty() && mst.size() < G.V() - 1) {
            Edge e = pq.remove();   //取出当前权值最小的边用于构建树
            int v = e.either();
            int w = e.other(v);
            if (uf.connected(v, w)) {  //v和w已连通，边e若再并入会产生环，所以边e失效
                continue;
            }
            uf.union(v, w);  //合并分量
            mst.add(e); //并入e
            weight += e.weight();   //边e的权值加入树的总权值中
        }
    }
    public Iterable<Edge> edges() {
        return mst;
    }
    public double weight() {
        return weight;
    }
}
