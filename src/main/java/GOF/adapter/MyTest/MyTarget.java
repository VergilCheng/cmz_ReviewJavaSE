package GOF.adapter.MyTest;

/**
 * 转接接口，客户端连接的端口
 */
public interface MyTarget {

    void handleReq(MyAdaptee adaptee);
}
