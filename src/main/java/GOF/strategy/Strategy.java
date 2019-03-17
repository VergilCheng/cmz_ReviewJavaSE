package GOF.strategy;

/**
 *
 */
public interface Strategy {
    double getPrice(double standardPrice);
}

class NewCustomerFewStrategy implements Strategy {

    public double getPrice(double standardPrice) {
        System.out.println("不打折原价");
        return standardPrice;
    }
}
class NewCustomerLotStrategy implements Strategy {

    public double getPrice(double standardPrice) {
        System.out.println("打折9折");
        return standardPrice*0.9;
    }
}
class OldCustomerFewStrategy implements Strategy {

    public double getPrice(double standardPrice) {
        System.out.println("打8.5折");
        return standardPrice*0.85;
    }
}
class OldCustomerLotStrategy implements Strategy {

    public double getPrice(double standardPrice) {
        System.out.println("打8折");
        return standardPrice*0.8;
    }
}