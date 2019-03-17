package GOF.state;

/**
 * 抽象状态
 */
public interface State {
    void handle();
}

/**
 * 具体状态
 *
 * 空闲状态
 */
class FreeState implements State {

    public void handle() {
        System.out.println("房间空闲没人住");
    }
}

/**
 * 预定状态
 */
class BookedState implements State {

    public void handle() {
        System.out.println("房间已经预定");
    }
}

/**
 * 入住状态
 */
class CheckedState implements State {

    public void handle() {
        System.out.println("房间已经入住");
    }
}