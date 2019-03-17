package GOF.adapter.MyTest;

/**
 * 以USB作为客户端调用连接的端口
 */
public class MyUSBAdapter implements MyTarget{

    //被适配器转接为别的端口
    MyAdaptee adaptee;

    public MyUSBAdapter(MyAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    public MyUSBAdapter() {

    }
    public void handleReq(MyAdaptee adaptee) {
        if (adaptee instanceof USBadaptee) {
            USBadaptee usBadaptee = (USBadaptee) adaptee;
            usBadaptee.usbRequest();
            return;
        }
        if (adaptee instanceof VGAadaptee) {
            VGAadaptee vgaadaptee = (VGAadaptee) adaptee;
            vgaadaptee.VGARequest();
            return;
        }
        if (adaptee instanceof HTMIadaptee) {
            HTMIadaptee htmiadaptee = (HTMIadaptee) adaptee;
            htmiadaptee.HTMIRequest();
            return;
        }
        if (adaptee instanceof PS2adaptee) {
            PS2adaptee ps2adaptee = (PS2adaptee) adaptee;
            ps2adaptee.ps2Request();
            return;
        }
        System.out.println("无当前接口，不能进行转接");
    }
}
