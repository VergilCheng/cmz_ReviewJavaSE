package GOF.adapter;

/**
 * 适配器（类适配器方式），实现target接口（适配器接口）
 * (相当于usb和ps2的转接器)
 */
public class Adapter extends Adaptee implements Target{


    public void handleReq() {
        System.out.println("客户端调用适配器，将USB接口转接为PS2接口");
        super.request();

    }
}
