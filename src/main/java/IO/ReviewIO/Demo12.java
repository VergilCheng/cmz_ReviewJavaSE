package IO.ReviewIO;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFile
 *
 * 1.用来读取日志大型文件：https://yq.aliyun.com/ziliao/13718
 * 2.seek方法可以指定任意位置进行文件读写，不同于IO流，需要从头读取，从头写入或者追加写入
 *
 */
@SuppressWarnings("all")
public class Demo12 {

    /**
     * 指定启示位置，读取全部内容
     */
    @Test
    public void test1() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/i.txt"), "r");//只读模式
            //随机读取
            raf.seek(3);
            byte[] flush = new byte[1024];
            int len;
            while ((len = raf.read(flush)) != -1) {
                System.out.println(new String(flush, 0, flush.length));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (raf != null) {
                try {
                    raf.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 指定起始位置，读取给定内容
     * 分块思想
     */
    @Test
    public void test2() {
        try {
            RandomAccessFile raf = new RandomAccessFile(new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/d.txt"),"r");
            //指定起始位置
            int beginIndex = 2;
            //指定要读取内容的大小
            int actualSize=258;
            //指定实际读取字节数组缓冲区
            byte[] flush = new byte[256];
            int temp ;
            while ((temp = raf.read()) != -1) {
                if (actualSize>temp) {
                    System.out.println(temp);
                    System.out.println(new String(flush,0,temp));
                    actualSize -= temp;
                }else{
                    System.out.println(new String(flush,0,temp));
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 对文件进行分块读取,并分块复制
     */
    @Test
    public void test3() {
        //对文件分块
        File from = new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/3.jpg");
        //文件总长度
        long allLength = from.length();
        //每块多少字节
        int blockSize = 1024*100;
        //多少块
        int size = (int) Math.ceil(allLength * 1.0 / blockSize);
        //起始位置
        int beginPos = 0;
        //每一块的实际大小
        int actualSize = (int) (blockSize > allLength ? allLength : blockSize);
        for (int i = 0; i <size; i++) {
            beginPos = blockSize * i;
            if (i == size-1) {//如果是最后一块
                actualSize = (int)allLength;
            } else {
                actualSize = blockSize;
                allLength -= actualSize;
            }
            System.out.println("第" + i + "块" + "每块的开始位置：" + beginPos + ",每块的大小：" + actualSize);
            File to = new File("C:/my code/cmz_ReviewJavaSE/src/main/resources/hebing/"+i+".jpg");
            split(beginPos,actualSize,from,to);
        }

    }

    /**
     * RandomAccessFile读取第i块的起始位置和实际长度
     *
     * 对分号的块写出去
     * @param beginPos
     * @param actualSize
     */
    public static void split(int beginPos, int actualSize,File from,File to) {
        RandomAccessFile raf = null;

        RandomAccessFile raf2 = null;

        try {
            raf = new RandomAccessFile(from, "r");
            raf2 = new RandomAccessFile(to, "rw");
            raf.seek(beginPos);
            byte[] flush = new byte[1024];
            int temp;
            while ((temp = raf.read(flush)) != -1) {//将actualSize再按照flush分块
                if (actualSize > temp) {
                    //String str = new String(flush, 0, temp);
                    //System.out.println(str);
                    raf2.write(flush,0,temp);
                    actualSize -= temp;
                } else {
                    //String str = new String(flush, 0, temp);
                    //System.out.println(str);
                    raf2.write(flush,0,actualSize);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (raf != null && raf2 != null) {
                try {
                    raf.close();
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
