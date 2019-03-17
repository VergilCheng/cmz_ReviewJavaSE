package GOF.composite.Anti_virus_software;

import java.util.LinkedList;

/**
 * 测试杀毒软件的组合模式
 */
public class Client {

    public static void main(String[] args) {
        AbstractFile f1,f2,f3,f4,f5,f6;
        f1 = new Folder("我的收藏");
        f2 = new TextFile("Hello.txt");
        f3 = new ImageFile("wym的照片.jpg");
        ((Folder) f1).add(f2);
        ((Folder) f1).add(f3);
        f1.killVirus();
        AbstractFile f11 = new Folder("电影");
        f4 = new VideoFile("神效侠侣,avi");
        f5 = new VideoFile("苍老师.avi");
        ((Folder) f11).add(f4);
        ((Folder) f11).add(f5);
        ((Folder) f1).add(f11);
        f1.killVirus();
    }


}
