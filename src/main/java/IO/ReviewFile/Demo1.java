package IO.ReviewFile;

import java.io.File;

/**
 * 两个常量:
 * 1.路径分隔符 :
 * 2.文件分隔符 \ /
 */
public class Demo1 {
    public static void main(String[] args) {
        //1.输出路径分隔符
        System.out.println(File.pathSeparator);
        //2,文件分隔符
        System.out.println(File.separator);//windows的
        //路径的表示形式
        String path = "F:/JAVA300集2018版(2.28修订,5.28日修订完毕)/08_IO流技术（共26集）";
        //推荐方式
        path="F:/JAVA300集2018版(2.28修订,5.28日修订完毕)/08_IO流技术（共26集）";
    }
}
