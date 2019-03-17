package IO.ReviewIO;

import Utils.CloseIOUtil;
import org.junit.Test;

import java.io.*;
import java.net.URL;

/**
 * 转换流：InputStreamReader与OutputStreamReader
 *
 * 连接字节流与字符流的桥梁，可以读取字节并使用指定的charset解码为字符
 * 1.以字符流的形式操作字节流(纯文本)
 * 2.指定字符集
 */
public class Demo07 {

    /**
     * 对键盘出入输出流做转换流操作：必须在main方法重写，在test中写不可以
     *
     *
     */

    public static void main(String[] args) {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String msg = "123";
            while (!"exit".equals(msg)) {
                msg = br.readLine();//循环写出
                bw.write(msg);
                bw.newLine();
                bw.flush();//切记不要忘记flush，不然会驻留在管道中
            }
        } catch (IOException e) {
            System.out.println("操作异常");
        }finally {
            CloseIOUtil.close(br,bw);
        }
    }



}
