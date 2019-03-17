package GOF.Proxy.dynamicProxy;


import java.lang.reflect.Proxy;

/**
 * 动态代理
 * <p>
 * 测试动态代理
 */
public class Client {

    public static void main(String[] args) {
        //真实角色
        Star real = new RealStar();
        //处理器
        StarHandler handler = new StarHandler(real);
        //生成代理类:传入类加载器，Class数组（用来通过反射生成所有的class对象），处理器
        Star proxy = (Star) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(), new Class[]{Star.class}, handler);
        try {
            proxy.bookTicket();
            proxy.sing();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }

    }


}
