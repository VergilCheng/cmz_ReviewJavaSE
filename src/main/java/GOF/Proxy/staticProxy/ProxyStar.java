package GOF.Proxy.staticProxy;

/**
 * 代理明星——>经纪人
 */
public class ProxyStar implements Star {

    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    public void confer() {
        System.out.println("代理角色签合同");
    }

    public void signContract() {
        System.out.println("代理角色签合同");
    }

    public void bookTicket() {
        System.out.println("代理角色签合同");
    }

    public void sing() {
        star.sing();
    }
    public void collectMoney() {
        System.out.println("代理角色签合同");
    }
}
