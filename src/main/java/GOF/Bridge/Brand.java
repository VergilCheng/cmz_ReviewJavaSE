package GOF.Bridge;

/**
 * 使用桥接模式——>接口
 * <p>
 * 品牌
 */
public interface Brand {
    void sale();
}

class lenovo implements Brand {

    public void sale() {
        System.out.println("销售联想电脑");
    }
}

class Dell implements Brand {

    public void sale() {
        System.out.println("销售戴尔电脑");
    }
}

class Shenzhou implements Brand {

    public void sale() {
        System.out.println("神州戴尔电脑");
    }
}