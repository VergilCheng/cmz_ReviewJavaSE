package Utils;

import java.io.*;

public class CloseIOUtil {
    /**
     *
     * 关闭流的静态方法
     */
    public static void close(Object stream) {
        if (stream instanceof InputStream) {
            InputStream is = (InputStream)stream;
            if (is!=null) {//避免空指针异常
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (stream instanceof OutputStream) {
            OutputStream os = (OutputStream) stream;
            if (os!=null) {//避免空指针异常
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else if (stream instanceof Reader) {
            Reader reader = (Reader) stream;
            if (reader!=null) {//避免空指针异常
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else if (stream instanceof Writer) {
            Writer writer = (Writer) stream;
            if (writer!=null) {//避免空指针异常
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 对上述关闭流的方法的重载，是更简单的实现方式
     */
    public static void close(Closeable... streams) {
        for (Closeable stream:streams) {
            if (stream != null) {
                try {
                    stream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
