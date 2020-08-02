package AST;

import java.util.Iterator;
import java.util.List;

/**
 * ASTList 是包含子节点的对象
 */
public class ASTList extends ASTree {

    private List<ASTree> children;

    public ASTList(List<ASTree> children) {
        this.children = children;
    }

    @Override
    ASTree child(int i) {
        if (i > children.size()) {
            throw new IndexOutOfBoundsException();
        }
        return children.get(i);
    }

    @Override
    int numChildren() {
        return children.size();
    }

    @Override
    Iterator<ASTree> children() {
        return children.iterator();
    }

    @Override
    String location() {
        for (ASTree asTree: children) {
            String s = asTree.location();
            if (s != null) {
                return s;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        String sp = "";
        for (ASTree t: children) {
            sb.append(sp);
            sp = " ";
            sb.append(t.toString());
        }
        return sb.append(")").toString();
    }
}
