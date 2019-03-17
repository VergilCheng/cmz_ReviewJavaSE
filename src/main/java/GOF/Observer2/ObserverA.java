package GOF.Observer2;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者：实现Observer接口
 */
public class ObserverA implements Observer {

    private int myState;

    public void update(Observable o, Object arg) {
        //完成赋值
        this.myState = ((ConcreteSubject) o).getState();
    }

    public int getMyState() {
        return myState;
    }

    public void setMyState(int myState) {
        this.myState = myState;
    }
}
