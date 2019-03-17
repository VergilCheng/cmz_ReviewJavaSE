package Thread;

import java.util.concurrent.CountDownLatch;

/**
 * 模拟12306抢票
 */
public class Demo02_Web12306 {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);
        Web12306 web12306 = new Web12306(latch);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(web12306);
            t.start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }

}

class Web12306 implements Runnable {


    private final CountDownLatch countDownLatch;

    private volatile int ticketNums = 30;

    public Web12306(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {

        while (true) {

            synchronized (this) {//锁住的是this这个对象，其实是地址，地址没有变化，地址中的值发生了变化，而不是锁住了这个值。
                if (ticketNums <=0) {
                    System.out.println("没票了");
                    countDownLatch.countDown();
                    return;
                }
                try {
                    //模拟网络延迟，会出现线程安全问题，使用sleep
                    Thread.currentThread().sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+":第"+ticketNums--+"张票");
            }
        }
    }
}
