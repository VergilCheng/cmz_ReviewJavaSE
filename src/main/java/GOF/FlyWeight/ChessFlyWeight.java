package GOF.FlyWeight;

/**
 * 抽象享元类
 *
 * 棋子
 */
public interface ChessFlyWeight {
    void setColor(String c);
    String getColor();
    void display(Coordinate coordinate);
}

/**
 * 具体享元类
 *
 * 具体棋子
 */
class ConcreteChess implements ChessFlyWeight {

    //颜色是共享的，内部状态
    private String color;


    public ConcreteChess(String color) {
        this.color = color;
    }

    public void setColor(String c) {
        this.color = c;
    }

    public String getColor() {
        return color;
    }

    public void display(Coordinate coordinate) {
        System.out.println("棋子颜色："+color+"棋子位置："+ coordinate.getX()+","+coordinate.getY());
    }
}


