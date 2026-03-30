package com.barca.bushiyun.DirectedGraph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DepthFirstOrder {  //基于DFS的顶点排序
    private boolean[] marked;
    private Deque<Integer> pre;  //所有顶点的前序排列，即dfs的调用顺序
    private Deque<Integer> post; //所有顶点的后序排列，即顶点遍历完成的顺序
    private Stack<Integer> reversePost;  //所有顶点的逆后序排列，即后序排列的顺序颠倒，用栈存储即可实现

    public DepthFirstOrder(Digraph G) {
        pre = new ArrayDeque<Integer>();
        post = new ArrayDeque<Integer>();
        reversePost = new Stack<Integer>();
        marked = new boolean[G.V()];
        for (int v = 0; v < G.V(); v++) {
            if (!marked[v]) {
                dfs(G, v);
            }
        }
    }

    private void dfs(Digraph G, int v) {
        pre.offerLast(v);  //调用即入队
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(G, w);
            }
        }
        post.offerLast(v);  // v再没有子结点可以调用了，遍历完成，入队
        reversePost.push(v);
    }

    //返回三种
    public Iterable<Integer> pre() {
        return pre;
    }
    public Iterable<Integer> post() {
        return post;
    }
    public Iterable<Integer> reversePost() {
        return reversePost;
    }


}
