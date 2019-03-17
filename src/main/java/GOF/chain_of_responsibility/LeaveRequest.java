package GOF.chain_of_responsibility;

/**
 * 封装请假的基本信息
 */
public class LeaveRequest {
    private String empName;
    private int leaveDays;
    private String resons;


    public LeaveRequest() {
    }

    public LeaveRequest(String empName, int leaveDays, String resons) {
        this.empName = empName;
        this.leaveDays = leaveDays;
        this.resons = resons;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(int leaveDays) {
        this.leaveDays = leaveDays;
    }

    public String getResons() {
        return resons;
    }

    public void setResons(String resons) {
        this.resons = resons;
    }
}
