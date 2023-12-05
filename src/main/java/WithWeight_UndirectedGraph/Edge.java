package WithWeight_UndirectedGraph;

public class Edge implements Comparable<Edge> {
    private final int v;  //顶点之一
    private final int w;  //另一个顶点
    private final double weight;  //边的权值

    public Edge(int v, int w, double weight) {
        this.v = v;
        this.w = w;
        this.weight = weight;
    }
    public double weight() {
        return weight;
    }
    public int either() {
        return v;
    }
    public int other(int vertex) {  //参数为其中一个已知顶点，返回另一个顶点
        if (vertex == v) {
            return w;
        }
        else if (vertex == w) {
            return v;
        }
        else {
            throw new RuntimeException("Inconsistent edge");  //抛出异常，不存在这样的边
        }
    }
    public int compareTo(Edge that) {  //不实现compareTo方法（即实现Comparable接口）的话没法使用优先队列
        if (this.weight < that.weight) {
            return -1;
        }
        else if (this.weight > that.weight) {
            return 1;
        }
        return 0;
    }
}
