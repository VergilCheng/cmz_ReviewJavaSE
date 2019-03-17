package GOF.Observer;

/**
 * 具体目标，状态
 */
public class ConcreteSubject extends Subject {

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        //主题对象（目标对象）发生变化，通知所有观察者
        this.notifyAllObservers();
    }

    //遍历输出集合中的观察者的状态
    public void printState() {
        for (Observer observer:list) {
            System.out.println(((ObserverA)observer).getMyState());
        }
    }
}
