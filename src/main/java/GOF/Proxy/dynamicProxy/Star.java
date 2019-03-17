package GOF.Proxy.dynamicProxy;

/**
 * 静态代理模式
 */
public interface Star {
    //面谈
    void confer() throws Throwable;
    //签合同
    void signContract() throws Throwable;
    //订票
    void bookTicket() throws Throwable;
    //唱歌
    void sing() throws Throwable;
    //筹钱
    void collectMoney() throws Throwable;
}
