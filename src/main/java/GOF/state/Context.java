package GOF.state;

/**
 * 上下文类：标注对象现在处于什么状态,维持不同状态之间的切换
 */
public class Context {

    private State state;

    //set方法来设置状态以及改变状态
    public void setState(State state) {
        System.out.println("修改状态");
        this.state = state;
        state.handle();
    }

}
