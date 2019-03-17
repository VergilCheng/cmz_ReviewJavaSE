package GOF.memento;

/**
 * 源发器类:状态在不断更新的数据
 */
public class Emp {

    private String ename;
    private int age;
    private double salary;


    /**
     *
     * 进行备忘操作，并返回备忘录对象
     *
     * @return
     */
    public EmpMemento memento() {
        return new EmpMemento(this);
    }

    /**
     * 数据回复操作
     * @return
     */
    public void recovery(EmpMemento empMemento) {
        this.ename = empMemento.getEname();
        this.age = empMemento.getAge();
        this.salary = empMemento.getSalary();
    }


    public Emp(String ename, int age, double salary) {
        this.ename = ename;
        this.age = age;
        this.salary = salary;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "ename='" + ename + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
