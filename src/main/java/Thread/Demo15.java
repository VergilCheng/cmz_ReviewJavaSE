package Thread;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 并发容器:CopyOnWriteArrayList
 */
public class Demo15 {

    public static void main(String[] args) {
        final CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(){
                public void run() {
                    list.add(Thread.currentThread().getName());
                }
            }.start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(list.size());
    }

}

