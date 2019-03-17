package Thread;

import java.util.concurrent.CountDownLatch;

/**
 * synchronized，synchronized同步块
 */
public class Demo12 {
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(20);
        final SafeWEB12306 web12306 = new SafeWEB12306(latch);
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
class SafeWEB12306 implements Runnable {


    private final CountDownLatch countDownLatch;

    private int ticketNums = 10;

    public SafeWEB12306(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {

        while (true) {
            //同步块，可以锁定任意对象，与同步方法中的synchronized不同在于：
            //1.可以提高并发效率，只锁定一部分
            //2.可以锁定指定对象，而同步方法只能锁定调用该方法的对象（this），而不能够锁定该对象中的其他对象(以成员属性的方式存在)
            //不过这里由于我们锁定了所有的代码块，所以与同步方法没什么不同。
            synchronized (this) {
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
                countDownLatch.countDown();
            }

        }
    }
}
