package Thread;

/**
 * 生产者与消费者模式
 * 1.管程法：生产者+缓冲区（并发容器，jnc包中有，这里我们写一个）+消费者
 * 优点：生产者与消费者实现解耦，提高效率
 */
public class Demo17 {

    public static void main(String[] args) {
        SynContainer synContainer = new SynContainer();
        Productor productor = new Productor(synContainer);
        Consumer consumer = new Consumer(synContainer);
        productor.start();
        consumer.start();
    }


}

//生产者
class Productor extends Thread {

    SynContainer synContainer;


    public Productor(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    public void run() {
        int max=100;
        //生产100个
        for (int i = 0; i <max ; i++) {
            System.out.println("生产第" + i + "产品");
                synContainer.push(new Streamedbun(i));

        }
    }
}
//消费者
class Consumer extends Thread {
    SynContainer synContainer;

    public Consumer(SynContainer synContainer) {
        this.synContainer = synContainer;
    }

    public void run() {
        int max=1000;//由于我们要消费1000个，但是生产者只生产100个，所以最后会等待
        //生产100个
        for (int i = 0; i <max ; i++) {

                System.out.println("消费第" +synContainer.pop().getId() + "产品");

        }
    }
}

//缓冲区
class SynContainer {


    private Streamedbun[] buns;


    private int count = 0;//计数器

    public SynContainer(int size) {
        buns = new Streamedbun[size];
    }

    public SynContainer() {
        buns = new Streamedbun[10];
    }


    public int size() {
        return count;
    }

    /**
     * 缓冲区暂时不需要扩容
     * @param bun
     */

    /*private void resize(int max) {
        Streamedbun[] temp = new Streamedbun[max];
        for (int i = 0; i < count; i++) {
            temp[i] = buns[i];
        }
        buns=temp;
    }*/


    //存储，生产
    public synchronized void push(Streamedbun bun)  {
        //if (count == buns.length) resize(2*buns.length);
        if (count == buns.length) {//如有数据填满只能等待，线程处在阻塞状态，这时候需要消费者线程！！来唤醒生产者继续消费
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.notifyAll();//通过此线程来唤醒所有阻塞的消费者，有物品可以继续消费了！！
        buns[count++] = bun;
    }

    //获取,消费
    public synchronized Streamedbun pop() {
        if (count == 0) {//重点：如果没有数据只能等待，线程处在阻塞状态，这时候需要生产者来唤醒消费者继续消费！！！
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Streamedbun bun = buns[--count];
        buns[count] = null;//避免对象游离
        //if (count > 0 && count == buns.length / 4) //resize(buns.length/2);
        this.notifyAll();//重点：通过此的消费者来唤醒所有等待的生产者，有空间可以继续生产了！！！
        return bun;
    }


}

//产品
class Streamedbun {
    private int id;

    public Streamedbun(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}