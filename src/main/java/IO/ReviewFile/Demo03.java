package IO.ReviewFile;

import org.junit.Test;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * File常用方法
 */
public class Demo03 {
    /**
     * 一、File获取文件名称与路径，相对路径，上级目录的方法
     * 1.getName():返回名称
     * 2.getPath():如果是绝对路径，返回绝对路径，如果创建File对象是通过相对路径，则返回相对路径
     * 3.getAbsolutePath():返回绝对路径
     * 4.getParent():返回上一级目录，如果是创建File是相对路径，返回null
     */
    @Test
    public void test1() {
        String parentPath = "F:/JAVA300集2018版(2.28修订,5.28日修订完毕)/08_IO流技术（共26集）";
        String fileName="demo2.txt";
        File src = new File(parentPath,fileName);//绝对路径创建File
        System.out.println("字符串参数构造方法："+src);
        src = new File(new File(parentPath),fileName);
        System.out.println("file对象与字符串参数构造方法："+src);
        //1.输出文件名称——getName():返回名称
        System.out.println("文件名称为："+src.getName());
        //2.输出文件路径
        System.out.println("文件路径："+src.getPath());
        //3.输出文件绝对路径
        System.out.println("文件绝对路径："+src.getAbsolutePath());
        //4.1返回上一级目录
        System.out.println("上一级目录："+src.getParent());
        //4.2返回上一级目录为null
        src = new File("demo2.txt");//相对路径创建File
        System.out.println("上一级目录："+src.getParent());
        System.out.println("文件绝对路径："+src.getAbsolutePath());//根目录在项目目录下
    }
    /**
     * 二、File类——文件判断信息
     * 注意：下列方法读取到的文件信息是文件是否存在，文件大小等等，并不会读取文件内的文件内容数据
     * 1.exists():文件是否存在
     */
    @Test
    public void test2() {
        /*
            1.文件是否存在
         */
        String path = "demo3.txt";//路径不存在
        File src = new File(path);
        System.out.println("文件是否存在："+src.exists());
        src=new File("F:/JAVA300集2018版(2.28修订,5.28日修订完毕)/08_IO流技术（共26集）/testFilePathAndIO","demo2.txt");
        System.out.println("文件是否存在："+src.exists());
        /*
            2.文件是否可读写
         */
        System.out.println("文件是否可读："+src.canRead()+",文件是否可写："+src.canWrite());
        /*
            3.判断文件是文件还是文件夹
            注意：如果文件不存在，那么方法会判断不存在的为文件夹！！
         */
        System.out.println("是否是文件："+src.isFile()+",是否是文件夹"+src.isDirectory());
        /*
            4.判断是否为绝对路径
         */
        System.out.println("是否为绝对路径："+src.isAbsolute());
        /*
            5.判断文件字节数
         */
        System.out.println("文件字节数："+src.length());
    }

    /**
     * 三、创建文件和删除文件
     * 1.createNewFile():创建文件，直接写到硬盘上
     * 2.delete():删除文件
     * 3.static createTempFile():创建临时文件
     * 4.deleteOnExit():删除临时文件
     */
    @Test
    public void test3() {
        String path = "F:/JAVA300集2018版(2.28修订,5.28日修订完毕)/08_IO流技术（共26集）/testFilePathAndIO/demo3.txt";
        String path1 = "F:/JAVA300集2018版(2.28修订,5.28日修订完毕)/08_IO流技术（共26集）/testFilePathAndIO/con";
        File src = new File(path);
        /*
            1.创建文件
         */
        if (!src.exists()) {
            try {
                boolean flag=src.createNewFile();
                System.out.println(flag?"success":"failed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{//如果文件存在，也会返回创建失败
            try {
                boolean flag=src.createNewFile();
                System.out.println(flag?"success":"failed");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*
            2.删除文件
         */
        if(src.exists()){
            boolean flag1 = src.delete();
            System.out.println(flag1);
        }else{//文件不存在，不会抛出异常，返回false
            boolean flag1 = src.delete();
            System.out.println(flag1);
        }
        /*
            3.创建临时文件与删除临时文件

            可在文件夹下看到文件的创建和消失
         */
        File temp = null;
        try {
            //创建临时文件
            temp=File.createTempFile
                    ("temp",".txt",new File("F:/JAVA300集2018版(2.28修订,5.28日修订完毕)/08_IO流技术（共26集）/testFilePathAndIO"));
            Thread.sleep(5000);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            //删除临时文件
            temp.deleteOnExit();
            System.out.println("删除临时文件成功");
        }
    }

    /**
     * 四、操作目录
     * 1.mkdir():创建目录，必须确保父目录存在，如果不存在创建失败
     * 2.mkdirs():
     * 3.list():返回目录下所有文件名称
     * 4.listFiles():返回当前目录下的所有File对象
     * 5.static listRoots():返回当前系统盘符的File对象
     */
    @Test
    public void test4() {
        //1.在规定路径下创建目录
        System.out.println("1.在规定路径下创建目录");
        String path = "F:/JAVA300集2018版(2.28修订,5.28日修订完毕)/08_IO流技术（共26集）/testFilePathAndIO/testMakeDir";
        File file = new File(path);
        boolean mkdir = file.mkdir();
        if (mkdir) {
            System.out.println("创建目录成功");
        }else{
            System.out.println("父目录不存在或者文件已经存在，创建目录失败");
        }
        //2.返回目录下的所有文件名称
        System.out.println("2.返回目录下所有文件名称");
        if (file.isDirectory()) {
            String[] subNames = file.list();
            for (String name:subNames) {
                System.out.println("目录下的所有文件："+name);
            }
        }
        //3.返回目录下的所有File对象
        System.out.println("3.返回目录下所有File对象");
        File[] files = file.listFiles();
        for (File f:files) {
            System.out.println(f);
        }
        /*
            4.文件过滤器:listFiles(new FilenameFilter(){})
            返回当前目录下，你规定格式的文件名称，为String数组
         */
        System.out.println("4.返回当前目录下所有被文件过滤器过滤的文件");
        String[] file1 = file.list(new FilenameFilter() {
            /**
             * dir代表当前目录，我们使用之前的对象file
             *
             * 我们返回后缀为.txt的文件
             * @param dir
             * @param name
             * @return
             */
            public boolean accept(File dir, String name) {
                System.out.println("匿名内部类中定义方法，返回当前目录的绝对路径："+dir.getAbsolutePath());
                //如果文件夹下的所有文件是文件不是目录并以txt为后缀结束则返回当前文件
                return new File(dir,name).isFile()&&name.endsWith(".txt");
            }
        });
        for (String name:file1) {
            System.out.println("txt文件有："+name);
        }
        //5.得到所有根路径
        System.out.println("5.得到所有根目录");
        File[] roots = File.listRoots();
        for (File root:roots) {
            System.out.println("根目录也就是盘符："+root);
        }
    }


}
