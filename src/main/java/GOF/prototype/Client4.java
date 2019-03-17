package GOF.prototype;
/**
 * 深复制，浅复制，反序列化实现克隆模式的效率对比
 *
 * 克隆模式使用场景：当创建一个对象非常耗时的时候，就可以使用克隆模式
 *
 */

import org.junit.Test;

import java.io.*;
import java.util.Date;

public class Client4 {

    /**
     * 测试new对象的时间
     */
    @Test
    public void test1() {
        long start = System.currentTimeMillis();
        for (int i = 0; i <10 ; i++) {
            try {
                new Laptop();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    /**
     * 测试浅克隆的时间
     */
    @Test
    public void test2() {
        long start = System.currentTimeMillis();
        Laptop laptop = null;
        try {
            laptop = new Laptop();
            for (int i = 0; i <999 ; i++) {
                Laptop laptop1= (Laptop) laptop.clone();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    /**
     * 测试深克隆的时间
     */
    @Test
    public void test3() {
        long start = System.currentTimeMillis();
        Laptop1 laptop =null;
        try {
            laptop = new Laptop1();
            for (int i = 0; i <999 ; i++) {
                Laptop1 laptop1= (Laptop1) laptop.clone();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

    /**
     * 测试序列化与反序列化实现克隆的时间
     */
    @Test
    public void test4() {
        long start = System.currentTimeMillis();
        Laptop1 laptop =null;
        try {
            laptop = new Laptop1();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(bos);

            for (int i = 0; i <999 ; i++) {
                //使用序列化和反序列化实现深复制
                //序列化
                oos.writeObject(laptop);
                byte[] bytes = bos.toByteArray();
                ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
                ObjectInputStream ois = new ObjectInputStream(bis);
                Laptop1 l = (Laptop1) ois.readObject();
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }

}


class Laptop implements Cloneable,Serializable{//笔记本电脑

    private Date date = new Date();

    public Laptop() throws InterruptedException {
        Thread.sleep(1000);//模拟对象创建耗时
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


class Laptop1 implements Cloneable,Serializable{//笔记本电脑

    private Date date = new Date();

    public Laptop1() throws InterruptedException {
        Thread.sleep(1000);//模拟对象创建耗时
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();
        Laptop1 laptop1 = (Laptop1) obj;
        laptop1.date = (Date) this.date.clone();
        return laptop1;
    }
}