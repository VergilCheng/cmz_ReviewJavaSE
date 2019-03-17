package GOF.Mediator;

public class Client {
    public static void main(String[] args) {

        Mediator m = new President();
        Department development = new Development(m);
        Department finacial = new Finacial(m);
        Department market = new Market(m);

        market.selfAction();
        market.outAction();
    }
}
