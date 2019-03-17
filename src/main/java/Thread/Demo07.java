package Thread;

/**
 * yiled方法：线程从运行状态直接转换到就绪状态
 * 注意：假设线程让出当前cpu，但是cpu也有可能再度分配时间给让出cpu时间的线程
 */
public class Demo07 {

    public static void main(String[] args) {

        MyYield myYield = new MyYield();
        new Thread(myYield,"yield01").start();
        new Thread(myYield,"yield02").start();
    }


}

class MyYield implements Runnable {

    public void run() {
        System.out.println(Thread.currentThread().getName()+"start");
        Thread.yield();//在让出cpu从
        System.out.println(Thread.currentThread().getName()+"end");
    }
}