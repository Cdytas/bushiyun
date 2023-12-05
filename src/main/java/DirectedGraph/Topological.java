package DirectedGraph;

import WithWeight_DirectedGraph.EdgeWeightedDigraph;

public class Topological {
    private Iterable<Integer> order;
    public Topological(Digraph G) {
        DirectedCycle cyclefinder = new DirectedCycle(G); //G中是否存在环？
        if (!cyclefinder.hasCycle()) { //无环才能拓扑排序
            DepthFirstOrder dfs = new DepthFirstOrder(G);
            order = dfs.reversePost();  //G中结点的逆后序排列
        }
    }
    public Iterable<Integer> order() {
        return order;  //返回结点的逆后序排列，即拓扑排序的结果，以栈存储
    }

    public boolean isDAG() {  //DAG：有向无环图
        return order != null;
    }
}
