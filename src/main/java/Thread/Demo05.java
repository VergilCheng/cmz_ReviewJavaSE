package Thread;

import java.util.concurrent.CountDownLatch;

/**
 * 线程阻塞——sleep方法
 * 1.sleep指定当前线程阻塞的毫秒数
 * 2.sleep存在异常InterruptedException
 * 3.sleep时间达到后线程进入就绪状态
 * 4.sleep可以模拟网络延迟，倒计时等等，可以模拟在这个情况下出现的线程安全问题
 * 5.每个对象都有一个锁，sleep不会释放锁
 */
public class Demo05 {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(3);
        WEB12306 web12306 = new WEB12306(latch);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(web12306);
            t.start();
        }
        latch.await();
        long end = System.currentTimeMillis();
        System.out.println(end-start);

    }
}
class WEB12306 implements Runnable {


    private final CountDownLatch countDownLatch;

    private volatile int ticketNums = 30;

    public WEB12306(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {

        while (true) {
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

