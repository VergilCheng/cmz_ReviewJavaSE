package GOF.Proxy.staticProxy;

/**
 * 静态代理
 * <p>
 * 测试静态代理
 */
public class Client {

    public static void main(String[] args) {
        Star real = new RealStar();
        Star proxy = new ProxyStar(real);
        proxy.confer();
        proxy.sing();
    }


}
