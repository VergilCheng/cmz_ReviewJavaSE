package GOF.Bridge;

public class Client {

    public static void main(String[] args) {
        //销售联想笔记本电脑
        Brand lenovo = new lenovo();
        Computer2 c1 = new Desktop2(lenovo);
        c1.sale();

        Brand dell = new Dell();
        Computer2 c2 = new Laptop2(dell);
        c2.sale();

        Brand shenzhou = new Shenzhou();
        Computer2 c3 = new Laptop2(shenzhou);
        c3.sale();

    }

}
