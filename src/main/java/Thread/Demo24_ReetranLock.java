package Thread;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 不可重入的锁：锁不可以延续使用
 */
public class Demo24_ReetranLock {

    ReetranLock lock=new ReetranLock();

    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        b();
        lock.unLock();
    }

    public void b() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        System.out.println("方法执行");
        lock.unLock();
    }

    public static void main(String[] args) {
        Demo24_ReetranLock demo = new Demo24_ReetranLock();
        try {
            demo.a();//会陷入死锁状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class ReetranLock {
    //是否占用
    private boolean isLocked = false;
    Thread lockedBy = null;//存储线程
    private int holdCount = 0;//计数器
    //使用锁
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while (isLocked&&lockedBy!=t) {
            wait();
        }
        isLocked = true;
        lockedBy = t;
        holdCount++;
    }
    //释放缩
    public synchronized void unLock() {
        if (Thread.currentThread() == lockedBy) {
            holdCount--;
            if (holdCount == 0) {
                isLocked = false;
                this.notify();
                lockedBy = null;
            }
        }
    }

    public int getHoldCount() {
        return holdCount;
    }
}

