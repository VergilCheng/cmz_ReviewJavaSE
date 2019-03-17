package Thread;

/**
 * join方法，当前线程直接接入cpu时间，让其他线程等待
 *
 */
public class Demo08 {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i <21 ; i++) {
                    System.out.println(Thread.currentThread().getName()+","+i);
                }
            }
        });
        t.start();
        Thread main = Thread.currentThread();
        for (int i = 0; i < 50; i++) {
            if (i == 20) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println(main.getName()+","+i);
            }
        }

    }

}
