package GOF.memento;

public class Client {

    public static void main(String[] args) {
        CareTaker careTaker = new CareTaker();
        Emp emp = new Emp("wym", 18, 900.0);
        System.out.println("第一次创建对象"+emp);
        System.out.println("备份");
        EmpMemento memento = emp.memento();
        //通过责任人类来对备忘录进行管理
        careTaker.setEmpMemento(memento);
        System.out.println("失误操作，让年龄非法，需要恢复");
        emp.setAge(123123);
        System.out.println(emp);
        //通过负责人来获得备忘录
        emp.recovery(careTaker.getEmpMemento());
        System.out.println(emp);
    }
}
