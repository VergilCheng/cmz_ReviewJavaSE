package Utils;

import java.io.*;

/**
 * 基于BufferedWriter与BufferedReader用于
 * txt文件拷贝
 *
 */
public class TxtFileUtils {


    public static void main(String[] args) {
        String fromPath = "C:\\my code\\cmz_ReviewJavaSE\\src\\main\\resources\\f.txt";
        String toPath = "C:\\my code\\cmz_ReviewJavaSE\\src\\main\\resources\\g.txt";
        boolean flag = copy(fromPath, toPath);
        System.out.println(flag);
    }


    /**
     *
     * 纯文本文件拷贝
     *
     * @param fromPath
     * @param toPath
     * @return
     */
    public static boolean copy(String fromPath,String toPath) {

        BufferedWriter bw = null;
        BufferedReader br = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File(toPath)));
            br = new BufferedReader(new FileReader(new File(fromPath)));
            String msg = null;
            while ((msg = br.readLine()) != null) {
                bw.append(msg);
                bw.newLine();
            }
            //如果填满内存会自动flush，如果没有填满则滞留在内存中，所以防止最后的字符串没有填满内存
            //而留在内存中flush一下。
            bw.flush();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        } finally {
            CloseIOUtil.close(bw,br);
        }
    }







}
