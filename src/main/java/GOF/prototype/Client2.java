package GOF.prototype;

import java.util.Date;

/**
 * 原型模式——>深复制
 */
@SuppressWarnings("all")
public class Client2 {

    public static void main(String[] args) {
        Date d = new Date(2312312312312L);
        Sheep2 s1 = new Sheep2("少利",d );
        System.out.println(s1+"，s1的name为："+s1.getName());
        try {
            Sheep2 s2 = (Sheep2) s1.clone();
            System.out.println(s2 + "，s2的name为：" + s2.getName());
            s2.setName("多利");
            System.out.println(s2 + "，s2克隆过后新的name为：" + s2.getName());
            if (s1.getBirthday() == s2.getBirthday()) {
                System.out.println("浅克隆后，s1与s2对象中所引用的date对象d，是同一个对象");
                System.out.println("原先s1与s2的date"+s1.getBirthday());
                s1.getBirthday().setTime(new Date().getTime());
                System.out.println("s2的date时间"+s2.getBirthday());
            } else {
                System.out.println("深克隆后，s1与s2对象中所引用的date对象d，不同一个对象");
                System.out.println("原先s1与s2的date"+s1.getBirthday());
                s1.getBirthday().setTime(new Date().getTime());
                System.out.println("s2的date时间"+s2.getBirthday());
            }
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

}



