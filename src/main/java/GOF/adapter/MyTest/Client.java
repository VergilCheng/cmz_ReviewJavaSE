package GOF.adapter.MyTest;

import org.junit.Test;

public class Client {



    public void test(MyTarget t,MyAdaptee adaptee) {
        t.handleReq(adaptee);
    }

    @Test
    public void testUsbAdapter() {
        Client client = new Client();
        MyTarget target = new MyUSBAdapter();
        MyAdaptee adaptee = new PS2adaptee();
        client.test(target,adaptee);
    }
    @Test
    public void testVgaAdapter() {
        Client client = new Client();
        MyTarget target = new MyVGAAdapter();
        MyAdaptee adaptee = new USBadaptee();
        client.test(target,adaptee);
    }

}
