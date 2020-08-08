package AST;

import Lexer.Token;

public class StringLiteral extends ASTLeaf {
    public StringLiteral(Token token) {
        super(token);
    }
}
