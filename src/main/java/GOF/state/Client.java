package GOF.state;

public class Client {

    public static void main(String[] args) {
        Context context = new Context();
        context.setState(new FreeState());
        context.setState(new BookedState());
    }

}
