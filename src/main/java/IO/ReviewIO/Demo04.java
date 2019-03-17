package IO.ReviewIO;

import Utils.CloseIOUtil;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;

/**
 * 应用：字节数组流与文件字节流的嵌套运用，将图片拷贝
 *
 * 流连接知识的补充(重点！！)：流链接是读——写——读——写的链式连接，而不是读——读——写——写的链式连接,过程如下：
 * step1.我们通过FileInputStream从本地读取数据到内存中，然后通过ByteArrayOutputStream再写到内存中
 * step2.我们通过ByteArrayInputStream将ByteArrayOutputStream写到内存中的数据读取到内存中，然后通过FileOutputStream写到本地。
 *
 * 避免错误：不要写成FileInputStream——>ByteArraysInputStream——>ByteOutputStream——>FileOutputStream的连接方式！
 * 这样会导致文件无法反序列化，经过第一次FileInputStream的读取后，文件已经序列化并存在于内存中了，这时候不需要再通过
 * ByteArrayInputStream去读取，而是需要将其写到别的内存中，之后再读取，再写出。流链接过程中读写是交替进行的。而不是全部读取完
 * 再进行写出操作！！
 */

public class Demo04 {

    public static void main(String[] args) {
        String sourcePath = "C:/my code/cmz_ReviewJavaSE/src/main/resources/3.jpg";
        String finalPath = "C:/my code/cmz_ReviewJavaSE/src/main/resources/7.jpg";

        byte[] datas = FileToArrayToFile(sourcePath);
        System.out.println(datas.length);
        boolean flag = ArrayToFile(datas, finalPath);
        System.out.println(flag);
    }

    public static byte[] FileToArrayToFile(String sourcePath)  {
        File file = new File(sourcePath);

        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream("C:/my code/cmz_ReviewJavaSE/src/main/resources/3.jpg");
            FileOutputStream fileOutputStream=null;
            ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
            byte[] flush = new byte[1024*10];//按照10kb字节去读取
            int temp;
            while ((temp = fileInputStream.read(flush)) != -1) {
                byteArrayOutputStream.write(flush,0,temp);
                byteArrayOutputStream.flush();
            }
            byte[] datas = byteArrayOutputStream.toByteArray();
            return datas;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        } finally {
            CloseIOUtil.close(fileInputStream);
        }
        return null;


    }
    public static boolean ArrayToFile(byte[] datas,String finalPath) {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(datas);
        FileOutputStream fileOutputStream = null;
        byte[] flush = new byte[100];//按照100个字节读取
        int temp;
        try {
            fileOutputStream= new FileOutputStream(finalPath);
            while ((temp=byteArrayInputStream.read(flush,0,flush.length))!=-1) {
                fileOutputStream.write(flush,0,flush.length);
                fileOutputStream.flush();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }




}
