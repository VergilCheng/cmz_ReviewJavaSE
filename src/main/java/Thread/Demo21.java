package Thread;

/**
 * 一条指令的执行步骤：
 * 1.将指令从内存中拿到寄存器中进行解码
 * 2.从对应寄存器（主存）中加载拷贝得到指令所需要的值到线程的工作内存中
 * 3.在工作内存中计算得到指令解码后的结果的值
 * 4.将该值从工作内存中写回到对应主存中去。
 *
 *
 * 数据依赖：如果两个操作访问同一个变量，且这两个操作中有一个为写操作，那么此时这两个操作之间就存在数据依赖，数据依赖分为下列三种类型
 * 1.写后读:a=1;b=a;
 * 2.写后写:a=1la=2;
 * 3.读后写:a=b;b=1;
 * 上面三种情况，只要重排序两个操作的执行顺序，那么程序的执行结果将会被改变。所以，编译器和处理器在重排序时，会遵守数据依赖性，编译器和
 * 处理器不会改变存在数据依赖关系的两个操作的执行顺序。
 *
 *
 * 指令重排：代码执行顺序与预期不一致，当代码之间没有依赖关系的时候，cpu或者虚拟机为了提高效率而将后面的代码先执行，从而提高效率以及cpu的使用率。
 * 目的：提高性能
 * 问题：多线程环境下可能会出现结果异常
 */
public class Demo21 {
    //变量1
    public static int a = 0;
    //变量2
    public static boolean flag = false;

    public static void main(String[] args) {
        while (true) {
        a=0;
        flag = false;
        //线程1：更改数据
        Thread t1= new Thread(){
          public void run() {
              a = 1;
              flag = true;
              System.out.println(Thread.currentThread().getName()+":"+a);
          }
        };
        //线程2：读取数据
        Thread t2= new Thread(){
            public void run() {
                if (flag) {
                    a *= 1;
                    System.out.println(Thread.currentThread().getName()+":"+a);
                }

                if (a == 0) {
                    System.out.println("指令重拍，a:" + a);
                }
            }
        };
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        }
    }
}
