package GOF.composite;

/**
 * 组合模式：用来处理树状结构的问题
 *
 *
 * 抽象组件：定义了容器和叶子节点的共同特点
 */
public interface Component {
    void operation();
}

/**
 * 叶子组件（具体组件）
 */
interface Leaf extends Component {

}

/**
 * 容器组件
 */
interface Composite extends Component {
    void add(Component c);
    void remove(Component c);
    Component getChild(int index);
}
