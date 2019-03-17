package Thread;

/**
 * 死锁：过多的同步可能造成相互不释放资源
 * 从而相互等待，一般发生于同步持有多个对象的锁
 *
 * 避免：不要在同一个代码块中持有多个对象的锁，造成锁嵌套
 */
public class Demo16 {

    public static void main(String[] args) {
        Makeup g1 = new Makeup(0, "王菲");
        Makeup g2 = new Makeup(1, "柏芝");
        g1.start();
        g2.start();
    }

}

//口红
class Lipstick {

}

//镜子
class Mirror {

}

//化妆
class Makeup extends Thread {

    static Lipstick lipstick=new Lipstick();
    static Mirror mirror=new Mirror();
    //选择
    int choice;

    //名字
    String girl;

    public Makeup(int choice,String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    public void run() {
        makeup();
    }
    //相互持有对方的对象锁，可能造成死锁
    public void makeup() {
        if (choice == 0) {
            synchronized (lipstick) {
                System.out.println(this.girl + "获得口红");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //锁嵌套会造成死锁
                /*synchronized (mirror) {
                    System.out.println("获得镜子");
                }*/

            }
            //将锁嵌套变成锁并列，可以算是一个解决死锁的思路
            synchronized (mirror) {
                System.out.println(girl+"获得镜子");
            }
        } else {
            synchronized (mirror) {
                System.out.println(this.girl + "获得镜子");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //同上
                /*synchronized (lipstick) {
                    System.out.println("获得口红");
                }*/
            }
            synchronized (lipstick) {
                System.out.println(girl+"获得口红");
            }
        }
    }
}