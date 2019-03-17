package Thread;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 线程阻塞——sleep方法
 * 1.sleep指定当前线程阻塞的毫秒数
 * 2.sleep存在异常InterruptedException
 * 3.sleep时间达到后线程进入就绪状态
 * 4.sleep可以模拟网络延迟，倒计时等等，可以模拟在这个情况下出现的线程安全问题
 * 5.每个对象都有一个锁，sleep不会释放锁
 */
public class Demo06 {

    //倒数10个数字，1秒一个
    @Test
    public void test1(){
        int num=10;
        while (num>=0) {
            try {
                Thread.sleep(1000);
                System.out.println(num--);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    //倒数10个数字，1秒一个
    @Test
    public void test2(){
        Date endTime = new Date(System.currentTimeMillis() + 1000 * 10);
        long end = endTime.getTime();
        while (true) {
            try {
                System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
                Thread.sleep(1000);
                endTime = new Date(endTime.getTime()- 1000);
                if (end - 10000 > endTime.getTime()) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
