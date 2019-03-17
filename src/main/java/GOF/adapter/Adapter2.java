package GOF.adapter;

/**
 * 适配器（对象适配器方式，使用了对象组合）
 * (相当于usb和ps2的转接器)
 */
public class Adapter2  implements Target{

    Adaptee adaptee;

    public Adapter2(Adaptee adaptee) {
        this.adaptee = adaptee;
    }

    public void handleReq() {
        System.out.println("客户端调用适配器，将USB接口转接为PS2接口");
        this.adaptee.request();

    }
}
