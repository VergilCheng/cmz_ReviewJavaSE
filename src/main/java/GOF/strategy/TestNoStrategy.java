package GOF.strategy;

/**
 * 不使用策略模式,实现起来容易，符合一般开发人员思路，假如类型特别多，算法非常复杂时，
 * 整个条件语句的代码就会变得很长，难于维护。如果有新增类型 ，那么就需要频繁的修改此处的代码，
 * 违反了开闭原则。
 */
public class TestNoStrategy {

    public double getPrice(String type, double price) {
        if ("普通客户小批量".equals(type)) {
            System.out.println("不打折，原价");
            return price;
        } else if ("普通客户大批量".equals(type)) {
            System.out.println("打9折");
            return price*0.9;
        } else if ("老客户小批量".equals(type)) {
            System.out.println("打8.5折");
            return price*0.85;
        } else if ("老客户大批量".equals(type)) {
            System.out.println("打8折");
            return price*0.8;
        }
        return price;
    }


}
