package com.barca.bushiyun.WithWeight_DirectedGraph;

import com.barca.bushiyun.sort.IndexMinPriorityQueue;

import java.util.Stack;

public class DijkstraSP {
    private DirectedEdge[] edgeTo;  //父链接数组，存储指向当前顶点的边
    private double[] distTo;  //存储从起点s到每个顶点的最短距离
    private IndexMinPriorityQueue<Double> pq;

    public DijkstraSP(EdgeWeightedDigraph G, int s) {
        edgeTo = new DirectedEdge[G.V()];
        distTo = new double[G.V()];
        pq = new IndexMinPriorityQueue<Double>(G.V());
        for (int v = 0; v < G.V(); v++) {
            distTo[v] = Double.POSITIVE_INFINITY;  //起点s到其他顶点的距离均初始化为无穷大
        }
        distTo[s] = 0;  //起点
        pq.insert(s, 0.0);
        while (!pq.isEmpty()) {
            relax(G, pq.delMin());  //每次删除队列中最小的元素，即从起点能到达的最近的顶点
        }
    }

    private void relax(EdgeWeightedDigraph G, int v) {  //检查从顶点v指出的每条边e，看看边e加入路径是否能缩短s到w的距离
        for (DirectedEdge e : G.adj(v)) {
            int w = e.to();
            if (distTo[w] > distTo[v] + e.weight()) {
                distTo[w] = distTo[v] + e.weight();
                edgeTo[w] = e;
                if (pq.contains(w)) {   //若索引优先队列中已存在索引值w，则更新w所关联的元素，否者，插入w和其关联的元素
                    pq.change(w, distTo[w]);
                }
                else {
                    pq.insert(w, distTo[w]);
                }
            }
        }
    }

    public double distTo(int v) {
        return distTo[v];
    }

    public boolean hasPathTo(int v) {
        return distTo[v] < Double.POSITIVE_INFINITY;
    }

    public Iterable<DirectedEdge> pathTo(int v) {
        if (!hasPathTo(v)) {
            return null;
        }
        Stack<DirectedEdge> path = new Stack<>();
        for (DirectedEdge e = edgeTo[v]; e != null; e = edgeTo[e.from()]) {
            path.push(e);
        }
        return path;
    }
}
