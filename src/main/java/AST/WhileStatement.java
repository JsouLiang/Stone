package AST;

import java.util.Iterator;

public class WhileStatement extends ASTree {
    @Override
    ASTree child(int i) {
        return null;
    }

    @Override
    int numChildren() {
        return 0;
    }

    @Override
    Iterator<ASTree> children() {
        return null;
    }

    @Override
    String location() {
        return null;
    }
}
