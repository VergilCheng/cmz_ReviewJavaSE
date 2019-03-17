package GOF.adapter;


import org.junit.Test;

/**
 * 测试类
 * （相当于例子中的笔记本，只能接USB接口）
 */
public class Client {

    public void test(Target t) {
        System.out.println("客户端通过USB接口调用PS2键盘");
        t.handleReq();
    }

    /**
     * 测试第一种适配器实现方式——>适配器继承被适配类，实现转接接口
     */
    @Test
    public void test1() {
        Client client = new Client();
        Target adapter = new Adapter();
        client.test(adapter);
    }

    /**
     * 测试第二种适配器实现方式——>适配器属性中有被适配的类，实现转接接口
     */
    @Test
    public void test2() {
        Client client = new Client();
        Target adapter = new Adapter2(new Adaptee());
        client.test(adapter);
    }

    /**
     * 测试自己的想法，将被适配类写成接口，实现宽范围的被适配类
     */


}
