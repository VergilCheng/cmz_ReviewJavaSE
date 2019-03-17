package GOF.Decorate;

public class Decorate03 {

    public static void main(String[] args) {
        ICar c1 = new Car();
        SuperCar flyCar = new FlyCar(c1);
        flyCar.move();
        System.out.println("******");
        SuperCar aiCar = new AICar(c1);
        aiCar.move();
        System.out.println("******");
        SuperCar swimCar = new SwimCar(c1);
        swimCar.move();
        System.out.println("******");
        SuperCar aiCar2 = new AICar(swimCar);
        aiCar2.move();
        System.out.println("******");
        SuperCar aiCar3 = new AICar(new SwimCar(new FlyCar(new Car())));
        aiCar3.move();
    }


}

//抽象组件
interface ICar {
    void move();
}
//具体组件
class Car implements ICar {

    public void move() {
        System.out.println("陆地上跑");
    }
}
//抽象装饰器
abstract class SuperCar implements ICar {

    //Java官方文档的解释：子类不能继承父类的私有属性，但是如果子类中公有的方法影响到了父类私有属性，那么私有属性是能够被子类使用的。
    //private ICar car;
    protected ICar car;//这里用private和protected都可以实现正常调用

    public SuperCar(ICar car) {
        this.car = car;
    }
    public void move() {
        this.car.move();
    }
}

//具体装饰器
class FlyCar extends SuperCar {

    public FlyCar(ICar car) {
        super(car);
    }

    private void fly() {
        System.out.println("车在飞");
    }
    @Override
    public void move() {
        super.move();
        this.fly();
    }
}
//具体装饰器
class SwimCar extends SuperCar {

    public SwimCar(ICar car) {
        super(car);
    }

    private void swim() {
        System.out.println("车在游");
    }
    @Override
    public void move() {
        super.move();
        this.swim();
    }
}
//具体装饰器
class AICar extends SuperCar {

    public AICar(ICar car) {
        super(car);
    }

    private void ai() {
        System.out.println("车在自己跑");
    }
    @Override
    public void move() {
        super.move();
        this.ai();
    }
}
