package com.barca.bushiyun.sort;

import java.util.Arrays;

public class IndexMinPriorityQueue <T extends Comparable<T>>{
    private T[] items; //用来存储元素的数组,泛型化，要求该元素对应的类必须实现Comparable接口
    private int[] pq; //保存每个元素在items数组中的索引值，pq数组需要堆有序
    private int[] qp;  //保存pq的逆序。qp数组的存在是为了快速找到某个索引值在pq中的下标，方便对pq进行堆有序调整
                                //qp数组的数组下标表示某个索引值，qp数组的值表示该索引值在pq中的下标位置
    private int n;  //记录堆中元素个数
    public IndexMinPriorityQueue(int capacity) {  //创建容量为capacity的indexMinPriorityQueue
        this.items = (T[])new Comparable[capacity];   //向下转型
        this.pq = new int[capacity ];
        this.qp = new int[capacity];
        this.n = 0;
        Arrays.fill(qp, - 1);  //默认情况下，队列中没有任何存储数据，也没有任何索引，让qp中的元素都为-1
    }

    //获取队列中元素的个数
    public int size() {
        return n;
    }
    //判断队列是否为空
    public boolean isEmpty() {
        return n == 0;
    }

    private boolean less(int i, int j) {  //判断索引值为pq[i]的元素值是否小于索引值为pq[j]的元素值。注意pq数组存储的是索引值。
        return items[pq[i]].compareTo(items[pq[j]]) < 0;
    }

    private void swap(int i, int j) {  //交换堆中下标i处和下标j处所存储的索引值
        //交换pq中的数据
        int temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
        //更新qp中的数据
        qp[pq[i]] = i;
        qp[pq[j]] = j;
    }

    //判断索引值k对应的元素是否存在
    public boolean contains(int k) {
        return qp[k] != -1;
    }

    //获取最小元素的关联索引
    public int minIndex() {
        return pq[0];  //堆顶索引关联的元素是最小的
    }

    //删除队列中最小的元素，并返回该元素关联的索引
    public int delMin() {
        //获取最小元素的关联索引
        int minIndex = pq[0];

        //交换pq中下标0处和最大下标处的索引值
        swap(0, n - 1);

        //删除qp中对应的内容
        qp[minIndex] = -1;

        //删除items中对应的内容
        items[minIndex] = null;

        //删除pq中最大索引处的内容
        pq[n - 1] = -1;
        //元素个数-1
        n--;
        //下沉操作
        sink(0);
        return minIndex;
    }

    //删除索引值k关联的元素
    public void delete(int k) {
        //找到索引值k在pq中的下标位置
        int index = qp[k];

        //交换pq中下标index处的索引值和下标n - 1处的索引值
        swap(index, n - 1);

        //删除qp中的内容
        qp[k] = -1;

        //删除items中的内容
        items[k] = null;

        //删除pq中的内容
        pq[n - 1] = -1;

        //索引值的数量-1
        n--;

        //堆的调整
        sink(index);
        swim(index);
    }
    //往队列中插入一个元素，并关联索引
    public void insert(int k, T t) {
        //判断k是否已经被关联，如果已经被关联，则不允许插入
        if(contains(k)) {
            return;
        }
        //把数据存储到items对应的i位置
        items[k] = t;

        //把索引值k存储到pq中下标n处,表示新增一个索引值
        pq[n] = k;

        //通过qp来记录pq中的k
        qp[k] = n;

        //通过堆上浮进行堆的调整
        swim(n);

        //元素个数增加
        n++;
    }

    //把与索引i关联的元素修改为t
    public void change(int i, T t) {
        //修改items数组中i位置的元素为t
        items[i] = t;
        //找到i在pq中出现的位置
        int k = qp[i];
        //堆调整
        sink(k);
        swim(k);
    }


    //使用上浮算法，使索引值为k的元素能在堆中处于一个正确的位置
    private void swim(int k) {
        while(k > 0 && less(k,(k - 1)/2)) {
            swap(k, (k - 1) / 2);
            k  = (k - 1) / 2;
        }
    }


    //使用下沉算法，使索引k处的元素能在堆中处于一个正确的位置
    private  void sink(int k) {
        while (2 * k + 1 < n) {  //至少存在左孩子
            int j = 2 * k + 1;
            if(j + 1 < n && less(j + 1, j)) {  //存在右孩子且比左孩子小
                j++;
            }
            if (less(k, j)) {  //父节点比小孩子小,退出下沉过程
                break;
            }
            swap(k, j);  //否则交换pq[k]和pq[j]所存储的索引值，即相当于交换了索引所关联的元素值的位置
            k = j;
        }
    }

}
