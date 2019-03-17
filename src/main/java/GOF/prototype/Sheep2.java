package GOF.prototype;

import java.util.Date;

/**
 * 原型模式——>克隆模式
 *
 * 用于深克隆
 */
public class Sheep2 implements Cloneable{//1997.英国的克隆羊，多利

    private String name;
    private Date birthday;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();//直接调用object对象的clone方法

        //添加如下代码，实现深复制，deep clone
        Sheep2 s = (Sheep2) obj;
        System.out.println(s==obj);//强转过后会生成新的对象吗？
        s.birthday = (Date)this.birthday.clone();//属性也进行克隆
        return obj;
    }


    public Sheep2(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Sheep2() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


}
