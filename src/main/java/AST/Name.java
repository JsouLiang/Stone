package AST;

import Lexer.Token;

/**
 * 变量名
 */
public class Name extends ASTLeaf {
    public Name(Token token) {
        super(token);
    }

    public String name() {
        return token().getText();
    }
}
