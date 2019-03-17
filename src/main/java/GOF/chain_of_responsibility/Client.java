package GOF.chain_of_responsibility;

public class Client {
    public static void main(String[] args) {
        //定义责任链链条
        Leader a = new Director("张三");
        Leader b = new Manager("李四");
        Leader c = new GeneralManager("王五");
        Leader b2 = new ViceManager("李小四");



        /*
         * 这里在客户端定义组织关系，框架中可以在配置文件中通过反射来设置
         */
        //组织责任链对象关系
        a.setNextLeader(b);
        b.setNextLeader(b2);
        b2.setNextLeader(c);
        //开始请假操作
        LeaveRequest req1 = new LeaveRequest("tom",30,"会英国老家探亲");
        //主任处理
        a.handleRequest(req1);
    }
}
