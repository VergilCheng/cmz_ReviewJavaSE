package IO.ReviewFile;

import java.io.File;

/**
 * 应用：输出子孙级目录和文件（绝对路径）
 */
public class Demo4 {
    public static void main(String[] args) {
        File root = new File("F:/JAVA300集2018版(2.28修订,5.28日修订完毕)/08_IO流技术（共26集）/testFilePathAndIO/testMakeDir");
        printPath(root);

    }
    public static void printPath(File file){
        if (file.isDirectory()) {
            //System.out.println("文件夹："+file);
            File[] sons = file.listFiles();
            if (sons.length==0) return;
            for (File f:sons) {
                if (f.isDirectory()) {
                    //System.out.println("文件夹："+f);
                    printPath(f);
                } else if(f.isFile()){
                    System.out.println("文件："+f);
                }
            }
        } else if(file.isFile()) {
            System.out.println("文件："+file);
        } else{
            return;
        }
    }
}
