package GOF.Observer;

/**
 * 具体观察者
 */
public class ObserverA implements Observer{

    private int myState;//myState需要目标对象的state值保持一致

    public int getMyState() {
        return myState;
    }

    public void update(Subject subject) {
        this.myState = ((ConcreteSubject) subject).getState();
    }
}
