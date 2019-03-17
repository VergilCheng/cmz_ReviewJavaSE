package Utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * RandomAccessFile来对文件进行切分读取和分割
 */
@SuppressWarnings("all")
public class SplitFileUtil {

    //源文件
    private File src;
    //目的地文件夹
    private String destDir;
    //所有分割后的文件存储路径
    private List<String> destPaths;
    //每块的大小
    private int blockSize;
    //块数
    private int size;

    //构造器
    public SplitFileUtil(String srcPath, String destDir,int blockSize) {
        this.src = new File(srcPath);
        this.destDir = destDir;
        this.destPaths = destPaths;
        this.blockSize = blockSize;
        this.destPaths = new ArrayList<String>();
        //对其他属性初始化
        init();
    }

    /**
     * 对其他属性初始化
     */
    private void init() {
        //文件总长度
        long len = this.src.length();
        this.size = (int) Math.ceil(len * 1.0 / blockSize);
        //路径
        for (int i = 0; i <size; i++) {
            this.destPaths.add(this.destDir +"/"+ i + "-" + this.src.getName());
        }
    }

    public void split() {
        //文件总长度
        long allLength = src.length();

        int beginPos = 0;
        //每一块的实际大小
        int actualSize = (int) (blockSize > allLength ? allLength : blockSize);
        for (int i = 0; i < size; i++) {
            beginPos = blockSize * i;
            if (i == size - 1) {//如果是最后一块
                actualSize = (int) allLength;
            } else {
                actualSize = blockSize;
                allLength -= actualSize;
            }
            System.out.println("第" + i + "块" + "每块的开始位置：" + beginPos + ",每块的大小：" + actualSize);
            splitDetail(i,beginPos, actualSize, src);
        }
    }

    private void splitDetail(int i,int beginPos, int actualSize, File from) {
        RandomAccessFile raf = null;

        RandomAccessFile raf2 = null;

        try {
            raf = new RandomAccessFile(from, "r");
            raf2 = new RandomAccessFile(this.destPaths.get(i), "rw");
            raf.seek(beginPos);
            byte[] flush = new byte[1024];
            int temp;
            while ((temp = raf.read(flush)) != -1) {//将actualSize再按照flush分块
                if (actualSize > temp) {
                    //String str = new String(flush, 0, temp);
                    //System.out.println(str);
                    raf2.write(flush, 0, temp);
                    actualSize -= temp;
                } else {
                    //String str = new String(flush, 0, temp);
                    //System.out.println(str);
                    raf2.write(flush, 0, actualSize);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
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

    /**
     * 文件合并
     */
    public void merge_test(String toPath) {
        //输出流
        OutputStream os = null;
        //输入流
        InputStream is = null;
        try {
            os = new BufferedOutputStream(new FileOutputStream(destDir+"/"+toPath, true));
            for (int i = 0; i <destPaths.size() ; i++) {//n个流的合并
                is = new BufferedInputStream(new FileInputStream(destPaths.get(i)));
                byte[] flush = new byte[100];
                int temp;
                while ((temp = is.read(flush))!=-1) {
                    os.write(flush,0,temp);
                    os.flush();
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null && is != null) {
                try {
                    os.close();
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        

    }

    /**
     * SquenceInputStream
     * @param args
     */
    public void merge(String toPath) {
        //输出流
        OutputStream os = null;
        //输入流:
        //序列流，可以将输入流整合到这个流中
        SequenceInputStream sequenceInputStream = null;
        //容器
        Vector<InputStream> vector = new Vector<InputStream>();
        try {
            os = new BufferedOutputStream(new FileOutputStream(destDir+"/"+toPath, true));
            sequenceInputStream = new SequenceInputStream(vector.elements());
            for (int i = 0; i < destPaths.size(); i++) {//将输入流放到容器中
                vector.add(new BufferedInputStream(new FileInputStream(destPaths.get(i))));
            }
            byte[] flush = new byte[100];
            int temp;
            while ((temp = sequenceInputStream.read(flush))!=-1) {
                os.write(flush, 0, temp);
                os.flush();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null && sequenceInputStream != null) {
                try {
                    os.close();
                    sequenceInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }




    public static void main(String[] args) {

        SplitFileUtil splitFileUtil = new SplitFileUtil("C:\\my code\\cmz_ReviewJavaSE\\src\\main\\resources\\d.txt",
                "C:\\my code\\cmz_ReviewJavaSE\\src\\main\\resources\\hebing",500);
        splitFileUtil.split();
        splitFileUtil.merge("final.txt");
    }

}
