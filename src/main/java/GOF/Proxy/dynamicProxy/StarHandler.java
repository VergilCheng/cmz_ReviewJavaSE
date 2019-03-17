package GOF.Proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 定义处理器，实现处理器接口，并在invoke方法中定义整个流程处理方法
 */
public class StarHandler implements InvocationHandler {

    //真实角色
    Star realStar;


    public StarHandler(Star realStar) {
        this.realStar = realStar;
    }


    //流程处理方法，做统一的流程控制
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("调用真实方法之前");
        //判断代理所调用的方法是否是唱歌方法
        if (method.getName().equals("sing")) {

            //如果是，则调用真实角色的唱歌方法
            method.invoke(realStar, args);

        } else {
            //如果不是，则调用代理的方法
            System.out.println("代理角色不能唱歌，得干别的");
        }
        System.out.println("调用真实方法之后");
        return null;
    }
}
