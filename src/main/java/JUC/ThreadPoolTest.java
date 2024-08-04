package JUC;


import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;


public class ThreadPoolTest implements Cloneable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3,5,1000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(5));
        NamingThreadFactory n = new NamingThreadFactory("线程池生产工厂");

        Callable<String> call1 = new MyCallable(100);   //创建一个实现了Callable接口的任务类对象
        Callable<String> call2 = new MyCallable(200);

        FutureTask<String> f1 = new FutureTask<String>(call1);  //利用任务类对象来创建一个未来任务对象
        FutureTask<String> f2 = new FutureTask<String>(call2);
        // 未来任务对象的作用？
        // 1、是一个任务对象，实现了Runnable接口.
        // 2、可以在线程执行完毕之后，用未来任务对象调用get方法获取线程执行完毕后的结果。

        // 把未来任务对象交给一个Thread对象
        threadPool.submit(f1);

        f1.cancel(false);
        boolean flag = f1.isCancelled();
        boolean flag2 = f1.isDone();
        System.out.println(flag);
        System.out.println(flag2);
        //只要任务被取消了，无论是否执行完毕，都get不到执行结果
//        String rs1= f1.get();
//        System.out.println(rs1);

        threadPool.submit(f2);
        // 获取线程执行完毕后返回的结果。
        // 注意：如果执行到这儿，假如上面的线程还没有执行完毕
        // 这里的代码会暂停，等待上面线程执行完毕后才会获取结果。
        String rs2 = f2.get();
        System.out.println(rs2);
    }
}

class NamingThreadFactory implements ThreadFactory {

    private final AtomicInteger threadNum = new AtomicInteger();
    private final String name;

    /**
     * 创建一个带名字的线程池生产工厂
     */
    public NamingThreadFactory(String name) {
        this.name = name;
    }

    @Override
    public Thread newThread(Runnable r) {
        Thread t = new Thread(r);
        t.setName(name + " [#" + threadNum.incrementAndGet() + "]");
        return t;
    }
}

class MyCallable implements Callable<String> {
    private int n;
    public MyCallable(int n) {
        this.n = n;
    }

    //重写call方法
    @Override
    public String call() throws Exception {
        //描述线程的任务，返回执行线程后的结果
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return  Thread.currentThread().getName() + "求出了1到n的和，和为： " + sum;
    }
}



