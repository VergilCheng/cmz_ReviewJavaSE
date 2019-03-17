package GOF.Observer2;

import java.util.Observable;

/**
 * 目标对象：继承Observable类
 */
public class ConcreteSubject extends Observable {

    private int state;



    public void set(int state) {
        this.state = state;//目标状态发生改变
        setChanged();//表示目标对象已经做了改变
        notifyObservers(state);//通知所有观察者
    }


    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
