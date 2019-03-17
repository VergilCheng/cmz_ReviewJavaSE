package Thread;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS:
 * 缺点：存在ABA问题，需要我们写代码解决
 */
public class Demo25 {
    //用原子锁，表示库存为4件
    private static AtomicInteger atomicInteger= new AtomicInteger(4);


    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(){
                @Override
                public void run() {
                    try {
                        //模拟网络延时
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    int left = atomicInteger.decrementAndGet();
                    if (left<0) {
                        System.out.println("抢完了");
                        return;
                    }
                    System.out.println(Thread.currentThread().getName()+"抢了一件");
                }
            }.start();
        }
    }

}
