package GOF.iterator;

/**
 * 迭代器接口
 */
public interface MyIterator {
    void first();//将游标指向第一个
    void next();//将游标指向下一个
    boolean hasNext();//当前游标是否拥有下一个对象
    boolean isFirst();//是否是第一个游标
    boolean isLast();//是否是最后一个游标
    //获取当前游标指向的对象
    Object getCurrentObj();
}
