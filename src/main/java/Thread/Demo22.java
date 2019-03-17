package Thread;

/**
 * volatile
 * 1.禁止指令重拍，会让线程操作失去原子性
 * ps：线程操作步骤：1.从堆中copy数据并load到线程的工作内存中。2.修改数据。3.将数据save回到堆中；
 *     volatile会破坏这种操作步骤完整执行，也就是原子性
 * 2.轻量级版synchronized，现在用的少.只保证数据的同步性
 * 3.cas可以保持线程操作的原子性
 * 4.让volatile修饰的变量，对所有线程都是即时性可见的！！
 */
public class Demo22 {

    //private static int num = 0;//不加上volatile，下面非main线程死循环不会结束,就不会去检查num是否更新为1了，main线程会看到num更新,但是cpu不会停止，因为非main线程在一直运行
    private volatile static int num = 0;//加上volatile，num对所有线程都即时性可见，下面死循环就会结束，num就会更新，cpu会停止

    public static void main(String[] args) {
        new Thread(){
            @Override
            public void run() {
                while (num == 0) {//此处不编写代码，只是让该线程忙得没时间去查看num是否更新了

                }
            }
        }.start();
        try {
            Thread.sleep(1000);
            num = 1;
            System.out.println(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
