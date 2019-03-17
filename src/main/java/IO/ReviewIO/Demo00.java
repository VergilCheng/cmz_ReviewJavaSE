package IO.ReviewIO;

import java.io.UnsupportedEncodingException;

/**
 * IO流
 *
 * 一、编码：字符串转换字节
 *
 * 二、解码乱码情况：
 * 1.字节数不够
 * 2.字符集不统一
 *
 * 三、编码与解码手段
 * 我目前所了解到在内存做解码的是String的构造方法new String（byte[]）来进行解码。可以用来对字符串解码
 * 也可以用来对纯文本文件txt格式文件解码。
 *
 * 四、javaIO流分类
 * 1.字节流
 * 2.字符流
 *
 */
public class Demo00 {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String msg = "努力锻炼，努力变强";
        //编码:encoding
        byte[] bytes = msg.getBytes();//工程中的字符集编码默认为工程字符集
        System.out.println("utf-8长度："+bytes.length);
        //编码为其他字符集
        byte[] bytes2 = msg.getBytes("utf-16");
        System.out.println("utf-16长度："+bytes2.length);
        //解码：decoding
        String str = new String(bytes);//解码默按照工程的字符集解码
        System.out.println(str);
        String str2 = new String(bytes2,"utf-16");//如果按照其他编码进行解码，则需要制定字符集
        System.out.println(str2);
    }

}
