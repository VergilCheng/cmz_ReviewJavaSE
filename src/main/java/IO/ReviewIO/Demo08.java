package IO.ReviewIO;

import Utils.CloseIOUtil;

import java.io.*;
import java.net.URL;

/**
 * 转换流应用：拔取百度的数据，网络爬虫简单应用
 */
public class Demo08 {

    /**
     * 网络爬虫最傻瓜
     * @param args
     */
    public static void main(String[] args) {
        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            //这里要使用http协议的网址，如果使用https则会发生安全问题
            InputStream is = new URL("http://www.baidu.com").openStream();//得到一个网络流
            InputStreamReader isr = new InputStreamReader(is, "utf-8");//使用InputStreamReader进行装饰，防止单字节读取导致中文乱码
            br = new BufferedReader(isr);//使用缓冲流，降低IO频率增快读写效率
            FileOutputStream fos = new FileOutputStream("C:\\my code\\cmz_ReviewJavaSE\\src\\main\\resources/baidu.html");
            OutputStreamWriter osw = new OutputStreamWriter(fos, "utf-8");//字节字符流只能装饰字节流，不能装饰字符流
            bw = new BufferedWriter(osw);
            String msg;
            while ((msg = br.readLine()) != null) {
                System.out.print(msg);
                bw.write(msg);
                bw.flush();
            }

        } catch (IOException e) {

        }finally {
            CloseIOUtil.close(bw,br);
        }

    }
}
