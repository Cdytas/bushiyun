package com.barca.bushiyun.DirectedGraph;

import java.util.Stack;

public class DirectedCycle {
    private boolean[] marked;
    private boolean[] onStack;
    private int[] edgeTo;
    private Stack<Integer> cycle;

    public DirectedCycle(Digraph G) {
        onStack = new boolean[G.V()];
        edgeTo = new int[G.V()];
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        onStack[v] = true;  //v记录到递归调用栈，表示当前路径上存在结点v
        marked[v] = true; //结点v已访问过
        for (int w : G.adj(v)) {
            if (this.hasCycle()) {  //已找到一个环，跳出递归
                return;
            }
            else if (!marked[w]) {
                edgeTo[w] = v;  //记录v为w的父节点
                dfs(G , w);
            }
            else if (onStack[w]) {  //发现v的子节点w已存在于递归调用栈中，说明w在v之前就已经到过了，存在回路。
                cycle = new Stack<Integer>();
                for (int x = v; x != w; x = edgeTo[x]) {  //cycle记录起点和终点都是v的一条环路
                    cycle.push(x);
                }
                cycle.push(w);
                cycle.push(v);
            }
        }
        onStack[v] = false;  //回溯，将v从路径上删去
    }

    public boolean hasCycle() {  //有环路吗？
        return cycle != null;
    }

    public Iterable<Integer> cycle() {  //返回一条环路
        return cycle;
    }
}
