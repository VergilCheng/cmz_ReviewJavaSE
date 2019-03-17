package GOF.command;

/**
 * 抽象命令
 */
public interface Command {

    /**
     * 这个方法返回结果为空的方法
     * 实际项目中，可以根据续期US合计多个不同的方法
     */
    void execute();

}

class ConcreteCommand implements Command {

    private Receiver receiver;//命令的真实执行者

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }


    public void execute() {
        //命令真正执行前或者后，执行相关的处理
        receiver.action();
    }
}
