package GOF.Mediator;

/**
 * 同事部门类的接口
 * <p>
 * 部门
 */
public interface Department {
    void selfAction();//做本部门的事情
    void outAction();//向总经理发出申请
}


/**
 * 以下为具体部门
 */
class Development implements Department {


    //持有中介者（总经理）的引用
    private Mediator mediator;


    public Development(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("development",this);
    }

    public void selfAction() {
        System.out.println("专心科研，研发项目");
    }

    public void outAction() {
        System.out.println("汇报工作！没钱了，需要资金支持");
        mediator.command("development");
    }
}


class Finacial implements Department {


    //持有中介者（总经理）的引用
    private Mediator mediator;


    public Finacial(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("financial",this);
    }

    public void selfAction() {
        System.out.println("数钱");
    }

    public void outAction() {
        System.out.println("汇报工作，钱太多了，怎么花");
        mediator.command("financial");
    }
}

class Market implements Department {


    //持有中介者（总经理）的引用
    private Mediator mediator;


    public Market(Mediator mediator) {
        this.mediator = mediator;
        mediator.register("market",this);
    }

    public void selfAction() {
        System.out.println("跑去接项目");

    }

    public void outAction() {
        System.out.println("汇报工作，钱太多了，怎么花");
        mediator.command("financial");
    }
}

