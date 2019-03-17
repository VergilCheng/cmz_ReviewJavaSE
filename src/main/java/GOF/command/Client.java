package GOF.command;

public class Client {

    public static void main(String[] args) {
        Command command = new ConcreteCommand(new Receiver());
        Invoker i = new Invoker(command);
        i.invoke();
    }

}
