package GOF.Singleton;

import java.io.DataInputStream;

/**
 * 单例模式：套路，在多线程环境下，对外存在一个对象
 * 1.构造器私有化，避免外部new对象
 * 2，提供私有的静态属性，存储对象地址
 * 3.提供公共私有的静态放飞，获取属性
 * <p>
 * 双重检索式单例模式
 */
public class DoubleCheckedLocking {

    //增加volatile避免指令重排，防止多线程环境下在已经有对象存在的情况下返回null
    private volatile static DoubleCheckedLocking instance;

    private DoubleCheckedLocking() {

    }

    public static DoubleCheckedLocking getInstance() {
        if (instance != null) {//外部判断，提高性能,避免不必要的同步，已经存在对象还要同步等待判断
            return instance;
        } else {
            synchronized (DoubleCheckedLocking.class){
                if (instance!= null) {
                    return instance;
                } else {
                    //new对象：1.开辟空间，2.初始化对象信息，3.返回对象的地址给引用
                    //所以new方法耗时较长，会发生指令重排，导致多线程环境下出问题，所以
                    //要在该类变量前加volatile，避免指令重排
                    instance=new DoubleCheckedLocking();
                    return instance;
                }
            }
        }
    }

    public static void main(String[] args) {

    }

}
