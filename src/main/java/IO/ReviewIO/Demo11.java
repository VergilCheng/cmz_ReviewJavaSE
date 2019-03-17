package IO.ReviewIO;

import Utils.CloseIOUtil;
import org.junit.Test;

import java.io.*;

/**
 * 打印流：PrintStream与PrintWriter
 *
 * 我们的SOUT就是打印流
 *
 *
 */
public class Demo11 {


    /**
     * PrintStream
     * 打印字节流
     */
    @Test
    public void test1() {
        //打印到控制台
        PrintStream ps = System.out;
        ps.println("打印流");
        ps.println(true);
        //打印到文件
        try {
            ps = new PrintStream(new BufferedOutputStream(new FileOutputStream("C:/my code/cmz_ReviewJavaSE/src/main/resources/h.txt")),true,"utf-8");
            ps.print("打印字节流");
            ps.println(true);
            //重定向输出端
            System.setOut(ps);
            System.out.println("change");//这样输出端从控制台重定向到了ps指定的文件中
            //重定向到控制台
            System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out)),true));//重定向回到标准的控制台
            System.out.println("i am back");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            CloseIOUtil.close(ps);
        }
    }

    /**
     * PrintWriter
     * 打印字符流
     */
    @Test
    public void test2() {

        PrintWriter ps = null;
        try {
            ps =new PrintWriter(
                    new OutputStreamWriter(
                            new BufferedOutputStream(
                                    new FileOutputStream("C:/my code/cmz_ReviewJavaSE/src/main/resources/i.txt")),"utf-8"
                    )
            );
            ps.print("打印字符流");
            ps.println(true);
            //重定向输出端
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            CloseIOUtil.close(ps);
        }
    }

}
