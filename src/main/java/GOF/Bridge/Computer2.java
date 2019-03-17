package GOF.Bridge;

/**
 * 使用桥接模式——>抽象类
 *
 * 电脑——>抽象类
 */
public abstract class Computer2 {

    //电脑持有品牌接口属性，这个属性作为桥梁连接电脑与品牌，是桥接模式的运用
   protected Brand brand;

    public Computer2(Brand brand) {
        this.brand = brand;
    }

    public void sale() {
        brand.sale();
    }
}

class Desktop2 extends Computer2 {

    public Desktop2(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("是台式机");
    }
}

class Laptop2 extends Computer2 {

    public Laptop2(Brand brand) {
        super(brand);
    }

    @Override
    public void sale() {
        super.sale();
        System.out.println("是笔记本");
    }
}
