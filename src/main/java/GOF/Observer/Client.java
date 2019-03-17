package GOF.Observer;

public class Client {
    public static void main(String[] args) {
        //目标对象
        ConcreteSubject subject = new ConcreteSubject();
        //多个观察者
        for (int i = 0; i <10 ; i++) {
            subject.register(new ObserverA());
        }

        //改变subject的状态
        subject.setState(3000);
        subject.printState();
    }
}
