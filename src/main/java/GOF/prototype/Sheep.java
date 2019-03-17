package GOF.prototype;

import java.io.Serializable;
import java.util.Date;

/**
 * 原型模式——>克隆模式
 *
 * 用于浅克隆
 */
public class Sheep implements Cloneable,Serializable {//1997.英国的克隆羊，多利

    private String name;
    private Date birthday;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object obj = super.clone();//直接调用object对象的clone方法
        return obj;
    }


    public Sheep(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public Sheep() {
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
