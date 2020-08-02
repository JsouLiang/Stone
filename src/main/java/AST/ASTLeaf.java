package AST;

import Lexer.Token;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * ASTLeaf 是叶子节点，不包含其他子节点的节点
 * 比如：常量，字面量，变量声明等
 */
public class ASTLeaf extends ASTree {
    private static List<ASTree> empty = new ArrayList<>();
    /**
     * 当前叶子节点的 token
     */
    private Token token;

    public ASTLeaf(Token token) {
        this.token = token;
    }

    @Override
    ASTree child(int i) {
        throw new IndexOutOfBoundsException();
    }

    public Token token() {
        return token;
    }

    /**
     * 叶子节点没有 child，所以 children count 返回 0
     */
    @Override
    int numChildren() {
        return 0;
    }

    /**
     * Iterator 需要返回一个与空集合关联的 iterator
     */
    @Override
    Iterator<ASTree> children() {
        return empty.iterator();
    }

    @Override
    String location() {
        return "at line " + token.getLineNumber() ;
    }

    @Override
    public String toString() {
        return "ASTLeaf{" +
                "token=" + token.getText() +
                '}';
    }
}
