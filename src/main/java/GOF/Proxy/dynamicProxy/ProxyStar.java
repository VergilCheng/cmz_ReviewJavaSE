package GOF.Proxy.dynamicProxy;

/**
 * 模拟动态代理生成的代理类结构——>由StarHandler生成的代理类
 */
public class ProxyStar implements Star{

    StarHandler handler;


    public ProxyStar(StarHandler handler) {
        this.handler = handler;
    }


    public void confer() throws Throwable {

        //下面方法只是模拟
        handler.invoke(this,this.getClass().getMethod("confer"),null);
    }

    public void signContract() throws Throwable {

        handler.invoke(this,this.getClass().getMethod("signContract"),null);
    }

    public void bookTicket() throws Throwable {
        handler.invoke(this,this.getClass().getMethod("bookTicket"),null);
    }

    public void sing() throws Throwable {
        handler.invoke(this,this.getClass().getMethod("sing"),null);
    }

    public void collectMoney() throws Throwable {
        handler.invoke(this,this.getClass().getMethod("collectMoney"),null);
    }
}
