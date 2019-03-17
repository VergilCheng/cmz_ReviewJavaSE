package GOF.template_method;

public class Client {

    public static void main(String[] args) {
        TemplateMethod method = new DrawMoney();
        method.process();
        //采用匿名内部类
        TemplateMethod method1 = new TemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要存钱");
            }
        };
        method.process();

        TemplateMethod method2 = new TemplateMethod() {
            @Override
            public void transact() {
                System.out.println("我要理财");
            }
        };
        method2.process();
    }

}
