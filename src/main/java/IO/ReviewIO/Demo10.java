package IO.ReviewIO;

import Utils.CloseIOUtil;
import org.junit.Test;

import java.io.*;
import java.util.Date;

/**
 * ObjectInputStream和ObjectOutputStream
 *
 * 1.对象流，和数据流很相似，除了数据流能处理的一些基本数据和字符串，还能处理对象
 * 2.对于对象的编码和解码，又叫做序列化和反系列化
 * 3.不是所有对象可以序列化，必须实现Serilizable接口
 */
public class Demo10 {

    public static void main(String[] args) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedOutputStream bos = new BufferedOutputStream(baos);
        ObjectOutputStream obs = null;
        try {
            //写出
            obs = new ObjectOutputStream(bos);
            obs.writeUTF("编码辛酸泪");
            obs.writeObject("有谁能体会");
            obs.writeObject(new Date());
            obs.writeInt(123);
            Employee employee = new Employee();
            employee.setAge(18);
            employee.setName("cmz");
            employee.setSalary(135000.00);
            obs.writeObject(employee);
            obs.flush();
            byte[] datas = baos.toByteArray();
            System.out.println(datas.length);
            //读取
            ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
            //注意!:读取方法的顺序要与写入方法的顺序一致！！，按什么写出，就按什么读入
            String o1 =ois.readUTF();
            String utf = (String) ois.readObject();
            Date date = (Date)ois.readObject();
            int i = ois.readInt();
            Employee e = (Employee) ois.readObject();
            System.out.println(o1 + utf + date + i);
            System.out.println("toString()中由于salary加了transient注解，所以不会输出："+e);

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            CloseIOUtil.close(bos);
        }

    }


}

class Employee implements Serializable{
       private String name;
    private int age;
    //transient：透明，用于在对象序列化
    //作用:某一个属性加上transient修饰符，将不会参与序列化与反序列化！！
    private transient double salary;


    public Employee() { }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}

