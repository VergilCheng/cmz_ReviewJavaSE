package GOF.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 目标
 */
public class Subject {

    protected List<Observer> list = new ArrayList<Observer>();

    public void register(Observer observer) {
        list.add(observer);
    }

    public void remove(Observer observer) {
        list.remove(observer);
    }

    //通知所有观察者更新状态
    public void notifyAllObservers() {
        for (Observer obj : list) {
            obj.update(this);
        }
    }

}
