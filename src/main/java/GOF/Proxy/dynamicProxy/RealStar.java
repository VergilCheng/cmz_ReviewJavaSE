package GOF.Proxy.dynamicProxy;

//真实角色
public class RealStar implements Star {
    public void confer() {
        System.out.println("真实角色订票");
    }

    public void signContract() {
        System.out.println("真实角色签合同");
    }

    public void bookTicket() {
        System.out.println("真实角色订票");
    }

    public void sing() {
        System.out.println("真实角色唱歌");
    }

    public void collectMoney() {
        System.out.println("真实角色筹钱");
    }
}
