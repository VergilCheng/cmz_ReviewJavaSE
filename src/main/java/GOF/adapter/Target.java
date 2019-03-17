package GOF.adapter;

/**
 * 转接接口——>客户端连接的接口
 *
 * 相当于USB接口,一对多，一个usb接口通过该适配器接口连接可以连接多个端口
 */
public interface Target {
    void handleReq();
}
