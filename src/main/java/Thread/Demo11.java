package Thread;

/**
 * 守护线程
 *
 * 注意:
 * 1.守护线程为用户线程所服务，jvm如果判断用户线程已经结束了，那么不会管守护线程
 * 是否会结束，从而会结束守护线程
 * 2.守护线程会等待用户线程结束才会结束他的生命周期
 */
public class Demo11 {

    public static void main(String[] args) {
        Thread you = new Thread(new You());
        Thread god = new Thread(new God());
        //设置为守护线程,一定要在启动线程之前设置为守护线程
        god.setDaemon(true);
        god.setPriority(Thread.MAX_PRIORITY);
        you.start();
        god.start();
    }

}
//普通线程
class You implements Runnable {

    public void run() {
        for (int i = 0; i <100 ; i++) {
            System.out.println("非守护线程运行"+i);

        }
    }
}

//守护线程Daemon
class God implements Runnable {

    public void run() {

        for (int i = 0; i <100 ; i++) {
            System.out.println("守护线程运行"+i);
            System.out.println("守护线程状态："+Thread.currentThread().getState());
        }
    }
}