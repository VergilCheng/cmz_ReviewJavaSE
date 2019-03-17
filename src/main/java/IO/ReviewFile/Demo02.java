package IO.ReviewFile;

import java.io.File;

/**
 *
 * 相对路径与绝对路径，构造File对象
 *
 *
 */
public class Demo02 {

    public static void main(String[] args) {
        String parentPath = "F:/JAVA300集2018版(2.28修订,5.28日修订完毕)/08_IO流技术（共26集）";
        String fileName="demo2.txt";
        /*1.相对路径：
            根据父路径与子路径创建file
         */
        System.out.println("1.相对路径实验");
        File src = new File(parentPath,fileName);
        System.out.println("字符串参数构造方法："+src);
        //或者
        src = new File(new File(parentPath),fileName);
        System.out.println("file对象与字符串参数构造方法："+src);
        //输出文件名称
        System.out.println("文件名称为："+src.getName());
        //输出文件路径
        System.out.println("文件路径："+src.getPath());

        /*
            2.绝对路径
         */
        System.out.println("2.绝对路径实验");
        src = new File("F:/JAVA300集2018版(2.28修订,5.28日修订完毕)/08_IO流技术（共26集）/demo2.txt");

        System.out.println("文件名称为："+src.getName());

        System.out.println("文件路径："+src.getPath());
        /*
            3.file对象的创建于文件是否真实存在的关系
            file构造方法只是建立对象与路径之间的关系，文件即使不存在，file对象也会创建成功
            但是通过exist方法判断是否存在则会做出正确的判断
         */
        System.out.println("3.文件不存在file对象能否创建成功");
        File srcTest = new File("F:/JAVA300集2018版(2.28修订,5.28日修订完毕)/08_IO流技术（共26集）/demo2000.txt");

        System.out.println("文件名称为："+srcTest.getName());

        System.out.println("文件路径："+srcTest.getPath());
        //判断文件是否存在
        System.out.println("文件是否存在："+srcTest.exists());
        /*
            4.如果我们没有给出盘符，则以user.dir构建File对象，也就是当前项目根目录下创建
         */
        System.out.println("4.不给出盘符创建");
        src=new File("demo3.text");

        System.out.println("文件名称为："+src.getName());
        //如果没有给出盘符，则getPath()方法输出的是相对路径
        System.out.println("文件路径："+src.getPath());
        //输出绝对路径
        System.out.println("文件绝对路径："+src.getAbsolutePath());
        //判断文件是否存在
        System.out.println("文件是否存在："+src.exists());
    }


}
