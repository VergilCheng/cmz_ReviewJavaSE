package IO.ReviewIO;

import java.io.*;

/**
 * DataOutputStream和DataInputStream
 * 1.写出后读取
 * 2.读取的顺序与写出保持一致
 *
 * 可以对ByteArrayOutputStream与ByteArrayInputStream进行装饰
 */
public class Demo09 {

    public static void main(String[] args) {

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(baos));
        DataInputStream dis = null;
        //操作数据类型+数据
        try {
            //写出：序列化
            dos.writeUTF("编码辛酸泪，有谁能体会");//写入String类型
            dos.writeInt(18);
            dos.writeBoolean(false);
            dos.writeChar('a');
            dos.flush();
            byte[] datas = baos.toByteArray();
            //读取：反序列化
            dis = new DataInputStream(new BufferedInputStream(new ByteArrayInputStream(datas)));
            //顺序与写出一致
            String msg = dis.readUTF();
            int age = dis.readInt();
            boolean flag = dis.readBoolean();
            char a = dis.readChar();
            System.out.println(msg+age+flag+a);
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

}
