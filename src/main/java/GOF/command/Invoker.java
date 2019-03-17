package GOF.command;

/**
 * 命令的调用者和发起者
 */
public class Invoker {

    private Command command;//也可以通过容器List来容纳很多命令，进行批处理，数据库底层事务管理就是类似的结构

    public Invoker(Command command) {
        this.command = command;
    }

    //业务方法，用于调用命令类的方法
    public void invoke() {
        command.execute();
    }
}
