package GOF.chain_of_responsibility;

/**
 * 抽象类
 */
public abstract class Leader {

    protected String name;
    protected Leader nextLeader;//责任链上的后继对象


    public Leader(String name) {
        this.name = name;
    }

    //设定责任链的后继对象
    public void setNextLeader(Leader nextLeader) {
        this.nextLeader = nextLeader;
    }

    //处理请求的业务核心方法,抽象方法
    public abstract void handleRequest(LeaveRequest request);
}

/**
 * 实现类，链条的一部分
 *
 * 主任
 */
class Director extends Leader{

    public Director(String name) {
        super(name);
    }

    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 3 || this.nextLeader == null) {
            System.out.println("主任处理员工：" + request.getEmpName() + "请假天数：" + request.getLeaveDays() + "理由：" + request.getResons());
            System.out.println("主任：" + this.name + "审批通过");
        } else {
            this.nextLeader.handleRequest(request);
        }
    }
}

/**
 * 实现类
 *
 * 经理
 */
class Manager extends Leader{

    public Manager(String name) {
        super(name);
    }

    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 10|| this.nextLeader == null) {
            System.out.println("经理处理员工：" + request.getEmpName() + "请假天数：" + request.getLeaveDays() + "理由：" + request.getResons());
            System.out.println("经理："+this.name+"审批通过");
        } else {
            this.nextLeader.handleRequest(request);
        }
    }
}


/**
 * 实现类
 *
 * 副总经理
 */
class ViceManager extends Leader{

    public ViceManager(String name) {
        super(name);
    }

    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 30 || this.nextLeader == null) {
            System.out.println("副总经理处理员工：" + request.getEmpName() + "请假天数：" + request.getLeaveDays() + "理由：" + request.getResons());
            System.out.println("副总经理：" + this.name + "审批通过");
        } else {
            this.nextLeader.handleRequest(request);
        }
    }
}


/**
 * 实现类
 *
 * 总经理
 */
class GeneralManager extends Leader{

    public GeneralManager(String name) {
        super(name);
    }

    public void handleRequest(LeaveRequest request) {
        if (request.getLeaveDays() < 30) {
            System.out.println("总经理处理员工：" + request.getEmpName() + "请假天数：" + request.getLeaveDays() + "理由：" + request.getResons());
            System.out.println("总经理："+this.name+"审批通过");
        } else {
            System.out.println("莫非这个人想辞职？");
        }
    }
}



