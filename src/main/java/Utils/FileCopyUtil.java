package Utils;

import java.io.*;

/**
 * 应用：使用文件字节传输流来做文件的拷贝
 */
@SuppressWarnings("all")//为了抑制代码重复的警告，不推荐使用all
public class FileCopyUtil {

    private static InputStream is;
    private static OutputStream os;
    private static boolean flag;
    private static int dataLength=20;//输入流的缓冲大小,我们这里假设为20字节


    public static boolean fileCopy(File source,File output) {
        try {
            is = new BufferedInputStream(new FileInputStream(source));
            os = new BufferedOutputStream(new FileOutputStream(output));
            flag = copy(is, os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            flag=false;
            System.out.println("文件不存在");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO流异常");
            flag=false;
        } finally {
            CloseIOUtil.close(is);
            CloseIOUtil.close(os);
            if (flag) {
                System.out.println("文件拷贝成功，路径为："+output.getAbsolutePath());
                return flag;
            }else{
                System.out.println("文件拷贝失败");
                return flag;
            }
        }
    }

    private static boolean copy(InputStream is,OutputStream os) throws IOException {
        //定义byte[]数组，读取输入流中的数据
        byte[] datas = new byte[dataLength];
        int len;
        while ((len=is.read(datas))!=-1) {
            os.write(datas,0,len);
            os.flush();
        }
        return true;
    }

    public static void main(String[] args) {
        File source = new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/3.jpg");
        File output = new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/8.jpg");
        boolean flag = FileCopyUtil.fileCopy(source, output);
        System.out.println(flag);
    }

}
