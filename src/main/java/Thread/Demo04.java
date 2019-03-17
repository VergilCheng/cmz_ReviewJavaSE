package Thread;

/**
 * 终止线程的方式
 * 1.线程正常执行完毕——>次数
 * 2.外部干涉——>加入标识
 * 3.不要使用stop，不安全。
 */
public class Demo04 {

    public static void main(String[] args) {
        TerminateThread tt = new TerminateThread(true, "cmz");
        Thread t = new Thread(tt);
        t.start();
        for (int i = 0; i <100 ; i++) {
            if (i == 90) {
                tt.terminate();
                System.out.println("结束了");
            }
            System.out.println("main线程正在执行"+i);
        }
    }

}

class TerminateThread implements Runnable {

    private boolean flag = true;

    private String name;

    public TerminateThread(boolean flag, String name) {
        this.flag = flag;
        this.name = name;
    }

    public void run() {
        //2.关联标识，true运行，false停止
        int i = 1;
        while (flag) {
            System.out.println(name+"循环执行了"+i+++"次");
        }
    }
    //3.对外提供方法改变标识
    public void terminate() {
        this.flag = false;
    }
}
