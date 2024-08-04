package JUC;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest2 {
    public static void main(String[] args) {
        Executors.newFixedThreadPool(5);  //LinkedBlockingQueue,可能堆积大量的请求，从而导致 OOM
        Executors.newSingleThreadExecutor(); //LinkedBlockingQueue

        Executors.newCachedThreadPool();
        //SynchronousQueue没有容量，不存储元素，目的是保证对于提交的任务，如果有空闲线程，则使用空闲线程来处理；否则新建一个线程来处理任务.
        // 如果任务数量过多且执行速度较慢，可能会创建大量的线程，从而导致 OOM

        Executors.newScheduledThreadPool(5);
        //DelayedWorkQueue内部元素并不是按照放入的时间排序，而是会按照延迟的时间长短对任务进行排序.
        // 内部采用的是“堆”的数据结构，可以保证每次出队的任务都是当前队列中执行时间最靠前的。
        //添加元素满了之后会自动扩容原来容量的 1/2，即永远不会阻塞，最大扩容可达 Integer.MAX_VALUE，所以最多只能创建核心线程数的线程




    }
}
