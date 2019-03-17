package Thread;

/**
 * 创建线程
 *
 * jni技术
 *
 */
public class Demo01 {

    public static void main(String[] args) {
        StartThread startThread = new StartThread();
        startThread.start();
        //startThread.run();//并不是多线程，而是方法调用了，有先后顺序
        for (int i = 0; i <30 ; i++) {
            System.out.println("一边coding");
        }
    }

}

class StartThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("一遍听歌");
        }
    }
}
