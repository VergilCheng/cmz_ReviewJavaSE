package IO.ReviewIO;

import org.junit.Test;

import java.io.*;


/**
 * 三、字节数组流：经常使用在一些服务器或者框架当中
 *
 * 与之前流的不同：
 * 1.（1）文件流是先将文件序列化，读入内存中，然后在反序列化或者继续序列化传输，是处理文件的
 *   （2）而字节数组流是处理字节的，也就是序列化好存在内存（可以是服务器的内存，本地内存或者网络中的内存）中的数据，
 *        这个字节数组可以是任何文件或者数据序列化而成的。
 * 2.
 * （1）文件流是java通过IO流的API以及jvm与操作系统打交道，申请使用操作系统的IO资源，这是因为文件一般是存储在本地的。
 * 而字节流不同，字节流一般处理存储在内存中的数据，所以jvm和程序可以字节访问到该资源，所以不需要向操作系统申请IO资源。
 * （2）由于不需要向操作系统申请资源，字节流则不需要调用close()方法，因为这一步有gc来帮忙回收，而文件流不一样，由于IO资源是
 * 操作系统的，jvm无权干涉，所以必须要调用流的关闭方法来通知操作系统释放IO流资源。
 * 3. 字节数组流是处理内存中的数据的，所以如果我们需要用字节数组流来处理数据，那么将数据转换成数组后不应当转换太大，因为
 * 内存空间较小。
 * 4.字节数组流的资源来源于内存中存储的字节，而文件字节流的资源来源于本地文件。
 *
 */
public class Demo03 {

    /**
     * ByteArrayInputStream
     * 1.new ByteArrayInputStream(byte[])
     * 2.read()
     * 3.int len = read(byte[])
     *
     *
     */
    @Test
    public void test1() {

        //1.创建源，源为字节数组
        byte[] src = "leetCode is full of challenge".getBytes();
        InputStream is = null;

        try {
            //2.选择流
            is = new ByteArrayInputStream(src);
            byte[] flush = new byte[8];
            //3.操作：读取
            int temp;
            while ((temp = is.read(flush)) != -1) {
                String msg = new String(flush,0,temp);
                System.out.print(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * ByteArrayOutputStream
     * 此类实现了一个输出流，其中的数据被写入一个 byte 数组。缓冲区会随着数据的不断写入而自动增长。可使用 toByteArray() 和 toString() 获取数据。
     *
     * 1.与文件输出流不同，该流不需要指定写出目的地，因为文件输出流的目的地为硬盘，空间大，而该流目的地为内存，
     * 我们去开辟内存可能会导致内存溢出，所以交给api构造方法自动开辟空间，并通过toByteArray()与toString()获取数据
     * 2.由于输出数据需要toByteArray()方法，是子类独有方法，不能发生多态，所以我们引用类型就是字节数组输出流
     *
     * 获取数据方法：toByteArray和toString
     *
     */
    @Test
    public void test2() {

        ByteArrayOutputStream os = null;
        try {
            os = new ByteArrayOutputStream();
            //内部资源
            String msg = "show me the result";
            byte[] data = msg.getBytes();
            os.write(data,0,data.length);
            os.flush();
            byte[] goal = os.toByteArray();
            String string = os.toString();
            System.out.println("通过toByteArray方法获取到数据的长度："+goal.length);
            System.out.println("通过toString方法获取到数据的长度："+string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
