package GOF.adapter;

/**
 * 被适配的类
 * （相当于例子中的PS2键盘，只有PS2接口，没有USB接口）
 */
public class Adaptee {

    public void request() {
        System.out.println("PS2接口的键盘打字");
    }

}
