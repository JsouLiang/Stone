package Lexer;

public class StringToken extends Token {
    private String value;
    StringToken(int line, String value) {
        super(line);
        this.value = value;
    }

    @Override
    public boolean isString() {
        return true;
    }

    @Override
    public String getText() {
        return value;
    }
}
