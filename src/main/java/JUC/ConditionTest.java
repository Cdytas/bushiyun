package JUC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionTest {

    public static void main(String[] args) {
        final ReentrantLock lock = new ReentrantLock();
        final Condition condition = lock.newCondition();

        Thread thread1 = new Thread(() -> {
            String name = Thread.currentThread().getName();

            lock.lock();
            System.out.println(name + " <==成功获取到锁" + lock);
            try {
                System.out.println(name + " <==进入条件队列等待");
                condition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " <==醒了");
            lock.unlock();
            System.out.println(name + " <==释放锁");
        }, "等待线程");

        thread1.start();

        Thread thread2 = new Thread(() -> {
            String name = Thread.currentThread().getName();

            lock.lock();
            System.out.println(name + " ==>成功获取到锁" + lock);
            try {
                System.out.println("========== 这里演示await中的线程没有被signal的时候会一直等着 ===========");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " ==>通知等待队列的线程");
            condition.signal();
            lock.unlock();
            System.out.println(name + " ==>释放锁");
        }, "通知线程");

        thread2.start();
    }
}
/**
 *      等待线程 <==成功获取到锁java.util.concurrent.locks.ReentrantLock@3642cea8[Locked by thread 等待线程]
 *     等待线程 <==进入条件队列等待
 *     通知线程 ==>成功获取到锁java.util.concurrent.locks.ReentrantLock@3642cea8[Locked by thread 通知线程]
 *             ========== 这里演示await中的线程没有被signal的时候会一直等着 ===========
 *     通知线程 ==>通知等待队列的线程
 *     通知线程 ==>释放锁
 *     等待线程 <==醒了
 *     等待线程  <==释放锁
 *
 */




