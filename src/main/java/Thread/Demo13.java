package Thread;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * synchronized同步块
 */
public class Demo13 {


    //会出现线程安全问题
    @Test
    public void test1() {
        final List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++) {
            new Thread(){
                public void run(){
                    list.add(Thread.currentThread().getName());
                }
            }.start();
        }
        try {
            Thread.sleep(10000);//让main线程休眠，不抢占cpu从而导致list还没有加到1000个就输出size
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }

    //不会出现线程安全问题,但是使用synchronized来解决main方法抢占cpu提前输出size是不可行的，因为main线程也有几率抢占得到synchronized锁
    //如果main线程不休眠，则还会出现list还没有添加完毕，main方法抢到锁之后提前输出list.size结束main线程，结果小于1000
    @Test
    public void test2() {
        final List<String> list = new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(){
                public void run(){
                    synchronized (list) {
                        list.add(Thread.currentThread().getName());
                    }
                }
            }.start();
        }
        synchronized (list) {
            System.out.println(list.size());
        }
    }

    //使用CountdownLatch
    //不会出现线程安全问题,也不会出现main线程抢占锁输出size
    @Test
    public void test3() {
        final List<String> list = new ArrayList<String>();
        final CountDownLatch countDownLatch = new CountDownLatch(1000);
        for (int i = 0; i < 1000; i++) {
            new Thread(){
                public void run(){
                    synchronized (list) {
                        list.add(Thread.currentThread().getName());
                    }
                    countDownLatch.countDown();
                }
            }.start();
        }
        try {
            countDownLatch.await();
            System.out.println(list.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


}
