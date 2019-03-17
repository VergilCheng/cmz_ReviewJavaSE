package Thread;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 高级并发编程初级：
 * 定时器Timer,TimerTask
 */
public class Demo19 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //延迟1s后执行安排
        timer.schedule(new MyTask(), 1000);
        //重复200毫秒再执行安排
        timer.schedule(new MyTask(), 1000,200);

    }
}

class MyTask extends TimerTask {

    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println("hello world");

        }
    }
}

