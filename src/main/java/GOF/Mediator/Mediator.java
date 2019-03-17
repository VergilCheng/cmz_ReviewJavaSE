package GOF.Mediator;

import java.util.HashMap;
import java.util.Map;

/**
 * 中介者接口
 *
 * 总经理
 */
public interface Mediator {

    void register(String dname, Department department);

    void command(String dname);

}

/**
 * 具体总经理
 */
class President implements Mediator {

    private Map<String, Department> map = new HashMap<String, Department>();

    public void register(String dname, Department department) {
        map.put(dname, department);
    }

    public void command(String dname) {
        map.get(dname).selfAction();
    }
}
