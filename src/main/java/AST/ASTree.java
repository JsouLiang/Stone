package AST;

import java.util.Iterator;

/**
 * ASTree 是抽象语法树所有节点的公共父类
 */
public abstract class ASTree implements Iterable<ASTree> {
    /**
     * 返回第 i 个子节点
     * @param i
     * @return
     */
    abstract ASTree child(int i);

    /**
     * 返回子节点的个数，如果没有子节点返回 0
     * @return 子节点个数
     */
    abstract int numChildren();

    /**
     * 返回一个用于遍历子节点的 iterator
     * @return 遍历子节点的 iterator
     */
    abstract Iterator<ASTree> children();

    /**
     * 返回一个 用于表示抽象语法树节点在程序内所处位置的字符串
     * @return
     */
    abstract String location();

    public Iterator<ASTree> iterator() { return children(); }
}
