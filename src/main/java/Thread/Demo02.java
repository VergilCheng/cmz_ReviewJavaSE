package Thread;

/**
 * 创建线程2：实现runnable接口，重写run方法
 *
 * 推荐：避免单继承的局限性，优先使用接口
 * 方便共享资源
 */
public class Demo02 {

    public static void main(String[] args) throws InterruptedException {
        Thread t0 = Thread.currentThread();
        StartThread2 st = new StartThread2();
        Thread t1 = new Thread(st);
        Thread t2 = new Thread(st);

        t0.sleep(500);
        t1.start();
        t2.start();
        System.out.println("main方法线程执行完毕");

    }

}

class StartThread2 implements Runnable {

    private Integer num=10;
    public void run() {
        System.out.println(Thread.currentThread().getName());
        synchronized (num) {
            num--;
            System.out.println(num);
        }
    }
}