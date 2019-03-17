package GOF.adapter.MyTest;

/**
 * 以VGA作为客户端调用连接的端口
 */
public class MyVGAAdapter implements MyTarget{

    //被适配器转接为别的端口
    MyAdaptee adaptee;

    public MyVGAAdapter(MyAdaptee adaptee) {
        this.adaptee = adaptee;
    }

    public MyVGAAdapter() {

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
        System.out.println("无当前接口，不能进行转接");
    }
}
