package GOF.composite.Anti_virus_software;

import GOF.composite.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象文件（抽象组件）
 */
public interface AbstractFile {
    void killVirus();
}

/**
 * 图片查杀（具体组件，叶子组件）
 */
class ImageFile implements AbstractFile {

    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    public void killVirus() {
        System.out.println("文本文件" + name + "进行查杀！");
    }
}

/**
 * 文本查杀（具体组件，叶子组件）
 */
class TextFile implements AbstractFile {

    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    public void killVirus() {
        System.out.println("文本文件" + name + "进行查杀！");
    }
}

/**
 * 视频查杀（具体组件，叶子组件）
 */
class VideoFile implements AbstractFile {

    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    public void killVirus() {
        System.out.println("文本文件" + name + "进行查杀！");
    }
}

/**
 * 容器组件
 */
class Folder implements AbstractFile {

    private String name;
    //文件夹下的子文件或者子文件夹
    //存储当前文件夹下的子节点
    private List<AbstractFile> list = new ArrayList<AbstractFile>();

    public Folder(String name) {
        this.name = name;
    }


    /**
     * add，remove，get方法为容器应该具有常规方法
     * @param file
     */
    public void add(AbstractFile file) {
        list.add(file);
    }

    public void remove(AbstractFile file) {
        list.remove(file);
    }

    public AbstractFile get(int index) {
        return list.get(index);
    }

    /**
     * 杀毒方法
     */
    public void killVirus() {
        System.out.println("文件夹" + name + "进行查杀");
        for (AbstractFile file : list) {//递归
            file.killVirus();
        }
    }
}