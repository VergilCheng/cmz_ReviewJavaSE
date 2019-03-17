package Thread;

/**
 * 不可重入的锁：锁不可以延续使用
 */
public class Demo24_NoReetranLock {

    MyUnReetranLock lock=new MyUnReetranLock();

    public void a() throws InterruptedException {
        lock.lock();
        b();
        lock.unLock();
    }

    public void b() throws InterruptedException {
        lock.lock();
        System.out.println("方法执行");
        lock.unLock();
    }
    

    public static void main(String[] args) {
        Demo24_NoReetranLock demo = new Demo24_NoReetranLock();
        try {
            demo.a();//会陷入死锁状态
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class MyUnReetranLock {
    //是否占用
    private boolean isLocked = false;
    //使用锁
    public synchronized void lock() throws InterruptedException {
        while (isLocked) {
            wait();
        }
        isLocked = true;
    }
    //释放缩
    public synchronized void unLock() {
        isLocked = false;
        this.notify();
    }

}

