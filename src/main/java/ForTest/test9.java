package ForTest;

import java.util.concurrent.*;

public class test9 {
    public static void main(String[] args) {
        ThreadPoolExecutor tpl = new ThreadPoolExecutor(3,5,1000, TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(5));
        Print p = new Print(5);
        FutureTask f0 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                p.print0();
                return null;
            }
        });

        FutureTask f1 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                p.print1();
                return null;
            }
        });

        FutureTask f2 = new FutureTask(new Callable() {
            @Override
            public Object call() throws Exception {
                p.print2();
                return null;
            }
        });

        tpl.execute(f0);
        tpl.execute(f1);
        tpl.execute(f2);

    }

    private static class Print {
        Semaphore[] se = new Semaphore[3];
        int n;

        public Print(int n) {
            this.n = n;
            se[0] = new Semaphore(1);
            se[1] = new Semaphore(0);
            se[2] = new Semaphore(0);
        }

        public void print0() throws InterruptedException {
            for (int i =1; i <= n; i++) {
                se[0].acquire();
                System.out.print(0);
                if (i % 2 == 1) {
                    se[1].release();
                }
                else {
                    se[2].release();
                }
            }
        }

        public void print1() throws InterruptedException {
            for (int i =1; i <= n; i += 2) {
                se[1].acquire();
                System.out.print(i);
                se[0].release();
            }
        }

        public void print2() throws InterruptedException {
            for (int i =2; i <= n; i += 2) {
                se[2].acquire();
                System.out.print(i);
                se[0].release();
            }
        }
    }
}

