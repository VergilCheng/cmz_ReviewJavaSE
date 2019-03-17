package GOF.strategy;

public class Client {
    public static void main(String[] args) {
        //可以通过反射和配置文件进行注入
        Strategy s1 = new OldCustomerLotStrategy();
        Context ctx = new Context(s1);
        ctx.printPrice(998);
    }
}
