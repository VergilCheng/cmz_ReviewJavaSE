package Thread;

import java.util.concurrent.CountDownLatch;

/**
 * synchronized，synchronized同步块
 *
 * 与Demo12作比较，使用了double checking，提高synchronized块的并发效率，同时保证线程安全
 *
 * 并发编程对synchronized块的理解：
 * 1.尽可能指定合理范围（不是指代码，而是数据的完整性）
 */
public class Demo14 {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(20);
        final finalSafeWEB12306 web12306 = new finalSafeWEB12306(latch);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 20; i++) {
            Thread t = new Thread(web12306);
            t.start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}

/**
 * run方法内部使用双重检索模式，分别对数据的不同情况进行锁定和判断，来提高并发效率
 */
class finalSafeWEB12306 implements Runnable {


    private final CountDownLatch countDownLatch;

    private int ticketNums = 10;

    public finalSafeWEB12306(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {

        /**
         * double checking
         */

        //check1:考虑没有票的情况
        //这里加入判断条件，当票数小于等于0时，则直接return，可以提高并发效率
        if (ticketNums <= 0) {
            return;
        }

        synchronized (this) {
            while (true) {
                //check2：
                //考虑最后一张票的情况
                if (ticketNums <= 0) {
                    System.out.println("没票了");
                    countDownLatch.countDown();
                    return;
                }
                try {
                    //模拟网络延迟，会出现线程安全问题，使用sleep
                    Thread.currentThread().sleep(101);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + ":第" + ticketNums-- + "张票");
            }
        }
    }
}

