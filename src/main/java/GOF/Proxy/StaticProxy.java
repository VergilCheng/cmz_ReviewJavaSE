package GOF.Proxy;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

/**
 * 静态代理——————Thread类和Runnable接口之间就是静态代理设计模式的实现
 * 接口：
 * 1、真实角色
 * 2、代理角色
 */
public class StaticProxy {

    public static void main(String[] args) {
        Marry cmz = new CMZ();
        Marry wedding = new WeddingCompany(cmz);
        wedding.Marry();
    }

}

/**
 * 使用结婚公司和我来演示代理模式，结婚公司代理包办事务，但是享受结婚的是自己
 */

//结婚接口
interface Marry {
    void Marry();
}

//真实角色
class CMZ implements Marry{

    public void Marry() {
        System.out.println("你是个基佬，结个屁的婚");

    }
}

//代理角色
class WeddingCompany implements Marry {

    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    public void Marry() {
        //代理之前
        before();
        //真实角色的自己的方法执行
        this.target.Marry();
        //代理之后
        after();
    }

    public void after() {
        System.out.println("结婚后结束");
    }

    public void before() {
        System.out.println("结婚前准备");
    }
}


