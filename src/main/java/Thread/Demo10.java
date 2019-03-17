package Thread;

/**
 * 线程优先级：优先级高的线程有大概率会被cpu分配时间，而不是一定会被cpu分配时间
 * <p>
 * 线程的优先级：1-10
 * 1.NORMAL_PRIORITY:5
 * 2.MAX_PRIORITY:10
 * 3.MIN_PRIORITY:1
 */
public class Demo10 {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());

        //创建线程
        Thread t0 = new Thread(new MyPrioroty());
        Thread t1 = new Thread(new MyPrioroty());
        Thread t2 = new Thread(new MyPrioroty());
        Thread t3 = new Thread(new MyPrioroty());
        Thread t4 = new Thread(new MyPrioroty());
        Thread t5 = new Thread(new MyPrioroty());
        //设置优先级，一定要在start方法前设置
        t0.setPriority(2);
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.NORM_PRIORITY);
        t3.setPriority(Thread.MIN_PRIORITY);
        t4.setPriority(3);
        t5.setPriority(4);
        //启动
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t0.start();
        //System.out.println(Thread.activeCount());
    }
}

class MyPrioroty implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+Thread.currentThread().getPriority());
    }
}
