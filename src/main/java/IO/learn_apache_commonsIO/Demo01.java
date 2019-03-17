package IO.learn_apache_commonsIO;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.LineIterator;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *  学习FileUtils
 */
public class Demo01 {

    /**
     * 文件与目录的大小
     */
    @Test
    public void tset1() {
        //文件大小
        long len = FileUtils.sizeOf(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/d.txt"));
        System.out.println(len);
        //目录大小
        len = FileUtils.sizeOf(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources"));
        System.out.println(len);

    }

    /**
     * 获取筛选过后的文件类型
     *
     * 文件过滤
     */
    @Test
    public void test2() {
        Collection<File> files = FileUtils.listFiles(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources"),
                FileFilterUtils.or(new SuffixFileFilter("jpg"),new SuffixFileFilter("txt")), DirectoryFileFilter.INSTANCE);//获取当前目录下子孙级别的jpg与txt后缀的所有文件
        for (File f:
             files) {
            System.out.println(f.getAbsolutePath());
        }
    }

    /**
     * 读取内容
     */
    @Test
    public void test3() {
        //读取文件
        try {
            //读取文件为字符串
            String msg = FileUtils.readFileToString(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/poetry.txt"),"utf-8");
            System.out.println(msg);
            //读取文件为byte数组
            byte[] datas = FileUtils.readFileToByteArray(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/poetry.txt"));
            System.out.println(datas.length);
            //逐行读取
            List<String> msgs = FileUtils.readLines(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/poetry.txt"), "utf-8");
            for (String str:
                 msgs) {
                System.out.println(str);
            }
            //使用迭代器
            LineIterator it = FileUtils.lineIterator(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/poetry.txt"), "utf-8");
            while (it.hasNext()) {
                System.out.println(it.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 写出内容
     */
    @Test
    public void test4() {
        try {
            //写出文件
            FileUtils.write(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/output.txt"), "学习是一种伟大的事业",
                    "utf-8", true);
            FileUtils.writeStringToFile(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/output.txt"), "学习是一种伟大的事业",
                    "utf-8", true);

            FileUtils.writeByteArrayToFile(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/output.txt"),
                    "学习也是一种幸福的事业".getBytes("utf-8"), true);
            //写出列表
            List<String> datas = new ArrayList<String>();
            datas.add("马云");
            datas.add("马化腾");
            datas.add("弼马温");
            FileUtils.writeLines((new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/output.txt")),datas,"......",true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * 拷贝文件
     */
    @Test
    public void test5() {
        try {
            //复制文件
            FileUtils.copyFile(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/3.jpg"),
                    new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/10.jpg"));
            //拷贝文件到指定目录
            FileUtils.copyFileToDirectory(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/3.jpg"),
                    new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/hebing"));
            //拷贝目录
            FileUtils.copyDirectory(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/hebing"),
                    new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/hebing2"));
            //拷贝目录到目录，成为其子目录
            FileUtils.copyDirectoryToDirectory(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/hebing"),
                    new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/hebing3"));

            //拷贝URL内容
            String url = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1538151659745&di=4aa51b19640e866703c269f4d1a9737d&imgtype=0&src=http%3A%2F%2Fwww.mycity-web.com%2Fwp-content%2Fuploads%2F2015%2F08%2Fmarvel.jpeg";
            FileUtils.copyURLToFile(new URL(url),new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/marvel.jpg"));

            String string = IOUtils.toString(new URL("http://www.baidu.com"), "utf-8");

            System.out.println(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
