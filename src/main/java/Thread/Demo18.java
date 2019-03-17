package Thread;

/**
 * 生产者与消费者模式
 *
 * 协作模型：信号灯法——>借助标志位
 *
 * 理解：信号灯（flag）法的写法其实和管乘法的条件判断本质上是一样的，都是用if判断什么时候
 * wait什么时候唤醒。
 *
 *
 */
public class Demo18 {

    public static void main(String[] args) {

    }

}

//生产者
class Player extends Thread {

    TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {

            if (i % 2 == 0) {
                this.tv.play("奇葩说");
            } else {
                this.tv.play("广告时间");
            }
        }

    }
}
//消费者
class Watcher extends Thread {

    TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {

        for (int i = 0; i < 20; i++) {
            tv.watch();
        }

    }
}
//同一个资源：电视
class TV {
    String voice;
    //信号灯
    //T表示演员表演，观众等待
    //F表示观众观看，演员等待
    boolean flag = true;

    //表演
    public synchronized void play(String voice) {
        //演员等待
        if (!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.voice = voice;
        System.out.println("表演了："+voice);
        this.notifyAll();
        this.flag = !flag;
    }

    //观看
    public synchronized void watch() {
        //观众等待
        if (flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("听到了" + voice);
        this.notifyAll();
        this.flag = !flag;
    }
}
