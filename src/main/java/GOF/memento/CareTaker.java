package GOF.memento;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 负责人类：管理备忘录对象（因为我们可以有多个历史记录）
 */
public class CareTaker {

    private EmpMemento empMemento;

    //管理备忘录的容器,一般我们用栈，或者map（idea使用的是map）
    //private Stack<Emp> stack = new Stack<Emp>();




    public EmpMemento getEmpMemento() {
        return empMemento;
    }

    public void setEmpMemento(EmpMemento empMemento) {
        this.empMemento = empMemento;
    }


}
