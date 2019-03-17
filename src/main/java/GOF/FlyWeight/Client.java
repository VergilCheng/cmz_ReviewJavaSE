package GOF.FlyWeight;

public class Client {
    public static void main(String[] args) {
        System.out.println("内部状态处理");
        ChessFlyWeight chess = ChessFlyWeightFactory.getChess("黑色");
        ChessFlyWeight chess1 = ChessFlyWeightFactory.getChess("黑色");
        System.out.println(chess == chess1);

        System.out.println("增加外部状态处理：");
        chess1.display(new Coordinate(10, 10));
        chess.display(new Coordinate(20, 10));
        System.out.println("chess1和chess其实是一个对象："+(chess==chess1)+"\r\n" +
                "对象相同用来表现内部状态颜色的相同，" +
                "而display方法通过传入外部对象来表现外部状态的不同");
    }
}
