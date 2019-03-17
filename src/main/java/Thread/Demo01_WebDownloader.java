package Thread;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Demo01_WebDownloader {

    public void download(String url,String name) {

        try {
            FileUtils.copyURLToFile(new URL(url),new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("下载失败");

        }
    }

    public static void main(String[] args) {
        String url = "";
        TDownloader tDownloader1 = new TDownloader("https://gss0.baidu.com/-Po3dSag_xI4khGko9WTAnF6hhy/zhidao/pic/item/d4628535e5dde71173c5d722a2efce1b9c1661cb.jpg" ,"C:/my code/cmz_ReviewJavaSE/src/main/resources/dmc1.jpg");
        TDownloader tDownloader2 = new TDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539162195690&di=ecea65ee15e0508bd1eb60a475971589&imgtype=0&src=http%3A%2F%2Fpic.baike.soso.com%2Fp%2F20131122%2F20131122143717-515983299.jpg" , "C:/my code/cmz_ReviewJavaSE/src/main/resources/dmc2.jpg");
        TDownloader tDownloader3 = new TDownloader("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1539162197093&di=3241f5f8d0c8a866d6879868cfbaa001&imgtype=jpg&src=http%3A%2F%2Fimg1.imgtn.bdimg.com%2Fit%2Fu%3D1407698581%2C2344805268%26fm%3D214%26gp%3D0.jpg",   "C:/my code/cmz_ReviewJavaSE/src/main/resources/dmc3.jpg");
        tDownloader1.start();
        tDownloader2.start();
        tDownloader3.start();
        System.out.println("图片下载启动开始");
    }
}

class TDownloader extends Thread {
    private String url;
    private String name;

    public TDownloader(String url, String name) {
        this.url = url;
        this.name = name;
    }

    @Override
    public void run() {
        Demo01_WebDownloader webDownloader = new Demo01_WebDownloader();
        webDownloader.download(url,name);
    }
}
