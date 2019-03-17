package Thread;

/**
 * 线程状态:Thread.State类
 *
 */
public class Demo09 {

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        Thread.sleep(100);
                        System.out.println(Thread.currentThread().getState());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        //观察状态
        Thread.State state = t.getState();
        System.out.println(state);//NEW,新生状态
        t.start();
        state = t.getState();//Runnable，就绪或者运行状态
        while (state!=Thread.State.TERMINATED){
            int num = Thread.activeCount();
            try {
                Thread.sleep(100);
                state = t.getState();//Runnable，就绪或者运行状态
                System.out.println(state);
                System.out.println("当前活跃线程数目："+num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.activeCount());

    }

}

