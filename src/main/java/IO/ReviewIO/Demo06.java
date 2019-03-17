package IO.ReviewIO;

import Utils.CloseIOUtil;
import org.junit.Test;

import java.io.*;

/**
 * BufferdWriter与BufferedReader
 *
 * 加入缓存，提高效率，可用于纯文本文件读写
 *
 */
public class Demo06 {


    /**
     * BufferedReader
     *
     * readLine()：读取一定数量的char数组，并将其转换成字符串，自动寻找空格并换行
     */
    @Test
    public void test1() {
        File file = new File("C:\\my code\\cmz_ReviewJavaSE\\src\\main\\resources\\c.txt");
        BufferedReader br= null;
        try {
            br = new BufferedReader(new FileReader(file));
            String msg = null;
            while ((msg = br.readLine()) != null) {
                System.out.println(msg);
            }

        } catch (IOException e) {

        } finally {
            CloseIOUtil.close(br);
        }
    }

    /**
     * BufferedWriter
     *
     * 不能进行追加写，只能覆盖写
     *
     * 1.write(String)
     * 2.append(String)
     * 3.newLine()：换行
     */
    @Test
    public void test2() {
        File file = new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/e.txt");
        BufferedWriter writer = null;
        String[] msgs = {"这是通过","BufferedWriter的write方法","追加的。","\r\n"};//内部资源数据
        try {
            writer = new BufferedWriter(new FileWriter(file));
            for (String msg:msgs) {
                //设置缓冲区域，为char[]，与Reader相同
                writer.write(msg);
            }
            writer.append("通过append方法").append("追加字符串");
            writer.newLine();//该子类独有的换行方法
            writer.append("通过newLine()方法换行后增加的字符串");
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
