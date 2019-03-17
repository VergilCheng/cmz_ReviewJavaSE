package GOF.Bridge;

/**
 * 桥接模式：将符合单一职责模式的类之间做桥接进行类的扩展
 *
 *
 * 单一职责原则：一个类最好只执行一个类的功能，而不是两个或两个以上类的功能，这样的话做扩展会很麻烦
 *
 */


//以下的类设计不符合单一职责原则
public interface Computer {
    void sale();
}

class Desktop implements Computer {

    public void sale() {
        System.out.println("销售台式机");
    }
}

class Laoptop implements Computer {

    public void sale() {
        System.out.println("销售笔记本");
    }
}

class Pad implements Computer {

    public void sale() {
        System.out.println("销售平板电脑");

    }
}

class LenovoDesktop extends Desktop {

    @Override
    public void sale() {
        System.out.println("销售联想笔记本");
    }
}


class LenovoLaptop extends Laoptop {

    @Override
    public void sale() {
        System.out.println("销售联想台式机");
    }
}