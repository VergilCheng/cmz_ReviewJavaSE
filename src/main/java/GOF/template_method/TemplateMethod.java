package GOF.template_method;

public abstract class TemplateMethod {
    //具体方法
    public void takeNumber() {
        System.out.println("排队取号");
    }

    public abstract void transact();//办理具体业务，钩子方法

    public void evaluate() {
        System.out.println("反馈评分");
    }

    //所有流程——>模板方法
    public final void process() {
        this.takeNumber();
        this.transact();
        this.evaluate();
    }
}

class DrawMoney extends TemplateMethod {

    public void transact() {
        System.out.println("我要取款");
    }
}
