package GOF.Decorate;

/**
 * 装饰器模式：高级流的使用模式
 *
 * 模拟咖啡
 *
 * 装饰器使用和构建流程：
 * 1.抽象组件：需要装饰的抽象对象(接口或者抽象父类)
 * 2.具体组件：需要装饰的对象
 * 3.抽象装饰类：包含了对抽象组件的引用以及装饰者共有的方法
 * 4.具体装饰类：被装饰的对象
 *
 */
public class Decorate02 {

    public static void main(String[] args) {
        Drink coffee = new Coffee();
        Drink milk = new Milk(coffee);//装饰
        Drink sugar = new Sugar(coffee);//装饰
        System.out.println(sugar.info() + sugar.cost());
        System.out.println(milk.info() + milk.cost());
        milk = new Milk(sugar);//装饰
        System.out.println(milk.info()+milk.cost());
    }


}

//抽象组件
interface Drink {
    double cost();
    String info();
}

//具体组件
class Coffee implements Drink{

    private String name = "原味咖啡";

    public double cost() {
        return 10;
    }

    public String info() {
        return this.name;
    }
}

//抽象装饰类
abstract class Decorate implements Drink {

    //对抽象组件的引用
    private Drink drink;


    public Decorate(Drink drink) {
        this.drink = drink;
    }

    public double cost() {
        return this.drink.cost();
    }

    public String info() {
        return this.drink.info();
    }
}

//具体装饰类
class Milk extends Decorate {

    //Java官方文档的解释：子类不能继承父类的私有属性，但是如果子类中公有的方法影响到了父类私有属性，那么私有属性是能够被子类使用的。
    public Milk(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*4;
    }

    @Override
    public String info() {
        return super.info()+"加入了牛奶";
    }
}
//具体装饰类
class Sugar extends Decorate {



    public Sugar(Drink drink) {
        super(drink);
    }

    @Override
    public double cost() {
        return super.cost()*2;
    }

    @Override
    public String info() {
        return super.info()+"加入了糖";
    }
}



