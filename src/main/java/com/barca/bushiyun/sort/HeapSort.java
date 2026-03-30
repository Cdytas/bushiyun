package com.barca.bushiyun.sort;

public class HeapSort {


/*
    本堆排序的下标从0开始，故：1、当子节点下标为n时，父节点下标为（n-1）/ 2
                                               2、父节点下标为k时，两个子节点下标为2*k+1和2*k+2
                                               3、最后一个非叶结点的下标为(n - 1) / 2。其中，n为数组最后一个下标，一般为array.length - 1。
                                               4、sink方法用于堆的构造和实现排序，swim方法用于插入新元素时维护堆的有序
*/
    public static void BigHeapSort(int[] a){
        int n = a.length - 1;
        for(int k = (n - 1) / 2;k >= 0; k--)
            BigSink(a,k,n);
        while(n > 0){
            Sort.ExchangeForInt(a,0, n--);    //缩短需要排序的数组长度，末尾都是已经排好的
            BigSink(a,0,n);
        }
    }

    public static void SmallHeapSort(int[] a){
        int n = a.length - 1;
        for(int k = (n - 1) / 2;k >= 0;k--)
            SmallSink(a,k,n);
        while(n > 0){
            Sort.ExchangeForInt(a,0,n--);
            SmallSink(a,0,n);
        }
    }

    public static void BigSink(int[] a,int k,int n){
        while(2 * k + 1 <= n){
            int j = 2 * k + 1;
            if(j < n && Sort.Less(a[j],a[j+1])) //右孩子比左孩子大
                j++;
            if(!Sort.Less(a[k],a[j]))     //父节点比大孩子大
                break;
            Sort.ExchangeForInt(a,k,j);
            k = j;
        }
    }

    public static void SmallSink(int[] a,int k,int n){
        while(2 * k + 1 <= n){
            int j = 2 * k + 1;
            if(j < n && Sort.Less(a[j + 1],a[j])) //右孩子比左孩子小
                j++;
            if(Sort.Less(a[k],a[j]))     //父节点比小孩子小
                break;
            Sort.ExchangeForInt(a,k,j);
            k = j;
        }
    }

    public static void BigSwim(int[] a,int k){
        while(k > 0 && Sort.Less(a[(k - 1)/2],a[k])){
            Sort.ExchangeForInt(a,(k - 1)/2,k);
            k  = (k - 1)/2;
        }
    }
    public static void SmallSwim(int[] a,int k){
        while(k > 0 && Sort.Less(a[k],a[(k - 1)/2])){
            Sort.ExchangeForInt(a,(k - 1)/2,k);
            k  = (k - 1)/2;
        }
    }
}
