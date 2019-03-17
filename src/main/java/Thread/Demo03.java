package Thread;

import java.util.concurrent.*;

/**
 * 创建线程：实现Callable接口,重写call方法
 *
 * 注释:callable接口是属于juc，java.util.concurrent包中的很多关于并发编程的扩展包，例如cas，可重入锁等等，
 * 需要工作多年后才能有所体会和了解。
 */
public class Demo03 {

    public static void main(String[] args) {
        //Callable接口执行多线程的步骤
        CDownloader cDownloader1 = new CDownloader("https://gss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/d4628535e5dde71173c5d722a2efce1b9c1661cb.jpg" ,"C:/my code/cmz_ReviewJavaSE/src/main/resources/dmc3.jpg");
        CDownloader cDownloader2 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539162195690&di=ecea65ee15e0508bd1eb60a475971589&imgtype=0&src=http%3A%2F%2Fpic.baike.soso.com%2Fp%2F20131122%2F20131122143717-515983299.jpg" , "C:/my code/cmz_ReviewJavaSE/src/main/resources/dmc4.jpg");
        CDownloader cDownloader3 = new CDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539162197093&di=3241f5f8d0c8a866d6879868cfbaa001&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D1407698581%2C2344805268%26fm%3D214%26gp%3D0.jpg",   "C:/my code/cmz_ReviewJavaSE/src/main/resources/dmc5.jpg");

        //创建线程池
        ExecutorService service = Executors.newFixedThreadPool(3);
        //提交执行
        Future<Boolean> future0 = service.submit(cDownloader1);
        Future<Boolean> future1 = service.submit(cDownloader2);
        Future<Boolean> future2 = service.submit(cDownloader3);
        //获取结果
        try {
            boolean r0 = future0.get();
            boolean r1 = future1.get();
            boolean r2 = future2.get();
            System.out.println(r2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally {
            service.shutdown();
        }
    }

}
class CDownloader implements Callable<Boolean> {
    private String url;
    private String name;

    public CDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Boolean call() throws Exception {
        Demo01_WebDownloader webDownloader = new Demo01_WebDownloader();
        webDownloader.download(url,name);
        return true;
    }
}

