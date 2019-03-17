package IO.ReviewIO;

import Utils.CloseIOUtil;
import org.junit.Test;

import java.io.*;

/**
 * 关于IO流的概念补充：
 * 1.IO流这个资源是属于操作系统的，jvm只能负责与操作系统沟通，让操作系统使用IO流并与程序交互。
 * 而java中的IO流则是对IO流的对象化，抽象化。
 * 2.java的IO流对象的作用是通过Input对象从IO流中读取数据到内存中（程序中）或者通过Output对象将数据写入内存中并
 * 通过IO流进行传输。
 * 3.IO流一定是成对出现的。
 *
 * IO流使用流程
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 *
 * 一、文件字节输出流
 *
 *
 */
public class Demo01 {

    /**
     *  一、文件字节输入流：FileInputStream
     *  作用:读取纯文本txt或者非文本txt文件，txt类型的文件可以用String类来读取文件中的字符串信息。
     *
     * 1.read():一个字节一个字节去读取，而不是按照一个字符一个字符去读取！！
     */
    @Test
    public void test1() {
        //1.创建源
        File src = new File("target/classes/a.txt");
        InputStream is = null;
        try {
            //2.选择流
            is = new FileInputStream(src);
            //3.操作：读取
            int read = is.read();//读取第一个数据a,返回int类型数据，为对应的ASCII编码
            int read1 = is.read();//读取第二个数据b，同上
            int read2 = is.read();//读取第三个数据c，同上
            System.out.println("ASCII编码："+read+","+"对应字符："+(char)read);
            System.out.println("ASCII编码："+read1+","+"对应字符："+(char)read1);
            System.out.println("ASCII编码："+read2+","+"对应字符："+(char)read2);
            //读取第四个数据，由于文件中只有三个字符，所以会返回32位个1，也就是-1
            int read3 = is.read();//读取到文件末尾
            System.out.println("读取到文件末尾则返回："+read3+","+"尝试将-1转换为char类型："+(char)read3);//不要忘记，ASCII编码对应到char，是从0到65535，是一个大于等于0的范围
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            CloseIOUtil.close(is);
        }
    }
    /**
     * 一、文件输入流：FileInputStream
     * 2.int len=read(byte[] data):按照规定的字节数组去读取，并将从输入流中读取到的字节
     * 放入到data的byte数组中，并返回一个int len，表示读取到的真实字节长度,这个len与data.length相同。
     * 如果最后读取的字节数达不到data.length,则读取最后剩余的字节数目，并通过补-1将剩余字节数补充到
     * data.length的长度，最后返回int len表示没有补充-1前所读取的剩余字节长度。
     *
     * 乱码问题：
     * 由于我们使用文件字节流来进行对纯文本文件的读取，如果文本文件为英文不会出现乱码（前提是文本编码与字符串编码相同），
     * 因为英文是一个字节。但是如果文本中有中文，那么会出现乱码情况。如果我们使用UTF-8编码，中文会占用三个字节。
     *
     * 乱码例子：假设我们的文本是“abc中”占用6个字节,并且我们的输入流的缓冲区域为data=byte[4]一次性读取4个字节，并且按照
     * 四个字节解码——String msg = new String(data,0,4)。那么就会出现“中”字乱码情况。这样后面的文本也会出现乱码。
     */
    @Test
    public void test2() {
        //1.创建源
        File src = new File("target/classes/c.txt");
        InputStream is = null;
        try {
            //2.选择流
            is = new FileInputStream(src);
            //规定缓冲，10个字节
            byte[] datas = new byte[3];//可以将10改成2,3来测试乱码情况
            //3.操作：读取
            int temp;
            while ((temp=is.read(datas))!=-1) { //按照10个字节的缓冲去读取
                System.out.println("从输入流中读取到"+temp+"字节（byte），是否等于byte数组的长度："+(temp==datas.length));
                System.out.println(new String(datas,0,temp,"utf-8"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.释放资源
            CloseIOUtil.close(is);
        }
    }
    /**
     * 二、文件字节输出流：FileOutputStream
     * 1.new FileOutputStream(File file,boolean append):这个构造方法IO流可以在已有文件上追加写，从而不会从头开始覆盖写
     *
     * 注意：下面注释中，所有并没有对IO流对象和IO流做明确区分，统一称作了IO流，是为了书写方便。读者在阅读的过程中请
     * 自行区分。
     */
    @Test
    public void test3() {
        //1.创建File对象，这时file只存在于内存中，并且没有文件数据，只是一个File对象
        File file = new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/d.txt");
        //2.选择流
        OutputStream os = null;
        String[] msgs = {"我日死你的妈","\r\n","鬼鬼你可真是个孤儿","\r\n","辣真的牛批","\r\n"};//内部资源数据
        try {
            //将File对象传入到os流中，如果文件存在，则根据os流的创建进行文件覆盖写或者追加写，
            //如果文件不存在，则首先在硬盘上创建文件，然后再根据os流的创建进行覆盖写或者追加写。
            os = new FileOutputStream(file,true);
            for (String msg:msgs) {
                byte[] data = msg.getBytes();
                //重点！！！！！！！！！！！
                //建议：数据转换成多少字节，就写多少字节，防止乱码出现
                //原因：为什么这么做：因为大多数情况下，我们是要从输入流中读取到字节，然后通过
                //输出流写入到磁盘中或者传输出去，那么大多数情况下，我们要根据输入流读取到多少
                //字节数目来进行读写。一般情况下我们从输入流中读取到的byte数组长度是输入流规定好的，
                //但是一旦输入流读取到数据末尾，那么大多数情况下为了补齐byte数组的长度，输入流会帮我们
                //补-1的，所以我们输出流一旦没有按照输入流的read(byte[])方法返回的int len来做数据写入的
                //话，会出现乱码情况。
                //结论：所以我们建议使用write(byte[],int off,int len)方法来做写操作。保障不会出现乱码情况！！
                os.write(data,0,data.length);
                //养成习惯，防止最后的字节数组没有达到输入流读取到的bytes[]数组的长度而滞留在内存中,flush一下
                os.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            CloseIOUtil.close(os);
            System.out.println("文件创建并写入完毕/或者文件追加写完毕");
        }
    }
}


