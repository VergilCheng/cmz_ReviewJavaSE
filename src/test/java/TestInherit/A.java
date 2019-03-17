package TestInherit;

public class A {
    public void a() {
        System.out.println("a");
    }

    public static void main(String[] args) {
        A b = new B();
        ((B) b).b();//多态后，就不能调用子类独有的方法了，除非类型强制转换
    }

}

class B extends A {
    public void b() {
        System.out.println("b");
    }
}


