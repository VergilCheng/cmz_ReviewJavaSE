package Thread;

import org.junit.Test;

/**
 * ThreadLocal：线程用来存储自己数据的空间，常见有数据库连接，用户连接，http请求等等私有属性和数据
 * 1.多个线程公用一个ThreadLocal区域，但是是每个线程在ThreadLocal中有自己的独立空间，如果有新线程，则在ThreadLocal中再度开辟一个自己的空间
 * 2.每个线程自身的数据更改不会影响其他线程
 * 方法：set.get.initialValue
 */
public class Demo23 {

    private static ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 1;
        }
    };

    /**
     * 1.测试线程的ThreadLocal值独立
     */
    public static class MyRun implements Runnable {

        public void run() {
            Integer left = threadLocal.get();
            System.out.println(Thread.currentThread().getName() + "还有：" + left);
            threadLocal.set(--left);
            System.out.println(Thread.currentThread().getName() + "剩下：" + threadLocal.get());
        }
    }

    @Test
    public void test1() {
        for (int i = 0; i <5 ; i++) {
            new Thread(new MyRun()).start();
        }
    }



    /**
     * 2.分析Threadlocal上下文 环境\
     *
     * 1、构造器：哪里调用，就属于哪里，找线程体
     * 2、run方法：本线程自己的
     */

    public static class MyRun1 implements Runnable {

        public MyRun1() {
            threadLocal.set(-100);
            System.out.println(Thread.currentThread().getName()+ "，构造器-->" + threadLocal.get());
        }

        public void run() {
            threadLocal.set(threadLocal.get()+100);
            System.out.println(Thread.currentThread().getName() + "，run方法-->" + threadLocal.get());
        }
    }


    @Test
    public void test2() {
        Thread t1=new Thread(new MyRun1());
        t1.start();
        t1.run();
    }

    /**
     * 3.InheritableThreadLocal:继承上下文 环境的数据 拷贝最新数据到线程工作空间中 起点
     *
     * 1、多个线程会共享InheritableThreadLocal中的数据，而不是独立计算，数据会随着线程的各种处理而对多个线程变化
     */
    private static ThreadLocal<Integer> inheritablethreadLocal = new InheritableThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 100;
        }
    };

    public static class MyRun2 implements Runnable {

        public MyRun2() {
            inheritablethreadLocal.set(-100);
            System.out.println(Thread.currentThread().getName()+ "，构造器-->" + inheritablethreadLocal.get());
        }

        public void run() {
            inheritablethreadLocal.set(inheritablethreadLocal.get()+100);
            System.out.println(Thread.currentThread().getName() + "，run方法-->" + inheritablethreadLocal.get());
        }
    }

    @Test
    public void test3() {
        Thread t1=new Thread(new MyRun2());
        t1.start();
        t1.run();
    }
}
