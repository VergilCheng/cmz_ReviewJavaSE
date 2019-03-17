package GOF.prototype;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;
import java.util.Date;

/**
 * 使用序列化与反序列化实现深克隆
 */
public class Client3 {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Date d = new Date(2312312312312L);
        Sheep s1 = new Sheep("少利",d );
        System.out.println(s1+"，s1的name为："+s1.getName());
       //使用序列化和反序列化实现深复制
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        //序列化
        oos.writeObject(s1);
        byte[] bytes = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        Sheep s2 = (Sheep) ois.readObject();
        System.out.println(s2 == s1);
        System.out.println(s2.getBirthday()==s1.getBirthday());
    }

}
