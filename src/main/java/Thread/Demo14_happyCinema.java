package Thread;

import java.util.concurrent.CountDownLatch;

public class Demo14_happyCinema {

    public static void main(String[] args) {
        final Cinema cinema = new Cinema(50, "cmz");
        int nums = 100;
        CountDownLatch countDownLatch = new CountDownLatch(nums);
        for (int i = 0; i < nums; i++) {
            new Thread(new Customer(cinema,3,countDownLatch)).start();
        }
        try {
            countDownLatch.await();
            System.out.println("还有"+cinema.getAvailable()+"个位置");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}

class Cinema {
    private int available;//可用的位置
    private String name;//名称

    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;

    }

    //判断购票是否成功
    public boolean bookTickets(int seats) {
        System.out.println("可用位置为：" + this.available);
        if (seats > available) {
            return false;
        } else {
            available -= seats;
            return true;
        }
    }


    public int getAvailable() {
        return available;
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Customer implements Runnable {

    private Cinema cinema;
    private CountDownLatch countDownLatch;
    private int seats;

    public Customer(Cinema cinema, int seats,CountDownLatch countDownLatch) {
        this.cinema = cinema;
        this.seats = seats;
        this.countDownLatch = countDownLatch;
    }
    public void run() {
        if (cinema.getAvailable()-seats <0) {
            System.out.println(Thread.currentThread().getName()+"余票不足："+cinema.getAvailable());
            countDownLatch.countDown();
            return;
        }
        synchronized (cinema) {
            if (cinema.getAvailable() <0) {
                System.out.println(Thread.currentThread().getName()+"余票不足："+cinema.getAvailable());
                countDownLatch.countDown();
                return;
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (cinema.bookTickets(seats)) {
                System.out.println(Thread.currentThread().getName()+"购票成功");
                countDownLatch.countDown();
                return;
            }else{
                System.out.println(Thread.currentThread().getName()+"余票不足："+cinema.getAvailable());
                countDownLatch.countDown();
                return;
            }
        }
    }
}