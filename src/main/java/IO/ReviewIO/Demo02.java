package IO.ReviewIO;

import Utils.CloseIOUtil;
import org.junit.Test;

import java.io.*;

/**
 * 二、文件字符输入与输入流
 * 用来处理纯文本txt文件类型的流
 *
 *
 */
public class Demo02 {
    /**
     * FileReader
     * 1.read(char[]);
     * 2.int read(char[],int off,int len);
     * 由于使用char数组缓冲，所以可以解决乱码问题
     */
    @Test
    public void test1() {
        File src = new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/c.txt");
        Reader reader = null;
        try {

            reader = new FileReader(src);
            //与FileInputStream的区别：不同于前者的缓冲区域是byte[]，这里的缓冲区域是char[],所以会避免FileInputStream的乱码情况
            //规定缓冲，50个字符
            char[] chars = new char[50];
            int temp;
            while ((temp=reader.read(chars))!=-1) {
                System.out.println("从输入流中读取到"+temp+"字符（char），是否等于char数组的长度："+(temp==chars.length));
                System.out.println(new String(chars,0,temp));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseIOUtil.close(reader);
        }
    }

    /**
     * FileWriter
     * 1.new FileWriter(File file,boolean append)
     * 2.new FileWriter(File file)
     *
     * 1.writer(char[],int off,int len)
     * 2.write(char[])
     * 3.write(String str)
     * 3.append(String str)
     */
    @Test
    public void test2() {
        File file = new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/d.txt");
        Writer writer = null;
        String[] msgs = {"这是通过","FileWriter的write方法","追加的。","\r\n"};//内部资源数据
        try {
            writer = new FileWriter(file,true);//append参数设置为true，可以在原文件基础上继续追加写入字符串，而不会对原文件进行覆盖。
            for (String msg:msgs) {
                //设置缓冲区域，为char[]，与Reader相同
                char[] chars = msg.toCharArray();
                writer.write(chars,0,chars.length);
            }
            writer.append("通过append方法").append("追加字符串");
            writer.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseIOUtil.close(writer);
            System.out.println("文件创建并写入完毕/或者文件追加写完毕");
        }
    }

}
