package IO.ReviewIO;

import Utils.CloseIOUtil;
import org.junit.Test;

import java.io.*;

/**
 *  BufferedInputStream And BufferedOutputStream
 *
 *  缓冲区域默认为8K
 *
 *
 * 减少IO次数，提高效率，可用于文件读写
 *
 */
public class Demo05 {


    /**
     * BufferedInputStream
     */
    @Test
    public void test1() {
        File file = new File("C:\\my code\\cmz_ReviewJavaSE\\src\\main\\resources\\a.txt");
        BufferedInputStream bis= null;
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            byte[] flush = new byte[1024 * 10];
            int temp = -1;
            while ((temp = bis.read(flush)) != -1) {
                String str = new String(flush, 0, temp);
                System.out.println(str);
            }

        } catch (IOException e) {

        } finally {
            CloseIOUtil.close(bis);
        }
    }


    /**
     * BufferedOutputStream
     *
     *
     */
    @Test
    public void test2() {
        BufferedOutputStream bos = null;
        ByteArrayOutputStream baos = null;
        try {
            baos = new ByteArrayOutputStream();
            String msg = "复习一下ByteArrayOutputStream的用法";
            System.out.println("原始数据的字节长度："+msg.getBytes().length);
            bos = new BufferedOutputStream(baos);
            byte[] data = msg.getBytes();
            bos.write(msg.getBytes(), 0, msg.length());
            bos.flush();
            String msg1 = baos.toString();
            System.out.println("写到内存中的字节长度:"+baos.toByteArray().length+","+msg1);
            System.out.println("所以如果不加BufferedOutputStream，可以写完42个字节 ，如果加了，则默认一次写28个字节，由于我们没有输入流读取，所以后续字节就写不到了");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseIOUtil.close(bos);

        }
    }
}
